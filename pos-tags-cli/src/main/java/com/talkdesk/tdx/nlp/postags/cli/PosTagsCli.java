package com.talkdesk.tdx.nlp.postags.cli;

import com.talkdesk.tdx.nlp.postags.dto.PosTags;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class PosTagsCli {

    public static final String HOSTNAME_OPTION = "h";
    public static final String PORT_OPTION = "p";
    public static final String TEXT_OPTION = "s";

    public static final String HOSTNAME = "hostname";
    public static final String PORT = "port";
    public static final String TEXT = "text";

    public static void main(String[] args) throws ParseException {
        ClientParameters clientParameters = getClientParameters(args);
        validateClientParameters(clientParameters);
        System.out.println(analyze(clientParameters));
    }

    private static void validateClientParameters(ClientParameters clientParameters) {
        if (!clientParameters.isValid()) {
            help();
            System.exit(1);
        }
    }

    private static ClientParameters getClientParameters(String[] args) throws ParseException {
        CommandLine cmd = parseOptions(args);
        String hostname = cmd.getOptionValue(HOSTNAME_OPTION);
        String port = cmd.getOptionValue(PORT_OPTION);
        String text = cmd.getOptionValue(TEXT_OPTION);
        return new ClientParameters(hostname, port, text);
    }

    private static void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("postags", getOptions());
    }

    private static CommandLine parseOptions(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        return parser.parse(getOptions(), args);
    }

    private static Options getOptions() {
        Options options = new Options();
        // TODO: change to required otion
        options.addOption(HOSTNAME_OPTION, true, HOSTNAME);
        options.addOption(PORT_OPTION, true, PORT);
        options.addOption(TEXT_OPTION, true, TEXT);
        return options;
    }

    private static PosTags analyze(ClientParameters clientParameters) {
        String url = String.format("http://%s:%s", clientParameters.getHostname(), clientParameters.getPort());
        ResteasyClient client = (ResteasyClient) ResteasyClientBuilder.newClient();
        ResteasyWebTarget webTarget = client.target(url);
        PosTagsClient proxy = webTarget.proxy(PosTagsClient.class);
        return proxy.analyze(clientParameters.getText());
    }

    @Getter
    @AllArgsConstructor
    private static class ClientParameters {
        private String hostname;
        private String port;
        private String text;

        public boolean isValid() {
            return hostname != null && port != null && text != null;
        }
    }
}
