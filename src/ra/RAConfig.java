package ra;

import jargs.gnu.CmdLineParser;
import jargs.gnu.CmdLineParser.OptionException;

public class RAConfig {
    private boolean help;
    private String inFileName;
    private String outFileName;
    private String password;
    private boolean promptPassword;
    private String schema;
    private String url;
    private String user;
    private boolean verbose;
    private String propsFileName;
    public RAConfig(String[] args) throws OptionException, RAConfigException{
        parseOptions(args);
    }

    public void parseOptions(String[] args) throws OptionException, RAConfigException {
        CmdLineParser cmdLineParser = new CmdLineParser();
        CmdLineParser.Option helpO = cmdLineParser.addBooleanOption('h', "help");
        CmdLineParser.Option inputO = cmdLineParser.addStringOption('i', "input");
        CmdLineParser.Option outputO = cmdLineParser.addStringOption('o', "output");
        CmdLineParser.Option passwordO = cmdLineParser.addStringOption('p', "password");
        CmdLineParser.Option promptPasswordO = cmdLineParser.addBooleanOption('P', "prompt-password");
        CmdLineParser.Option schemaO = cmdLineParser.addStringOption('s', "schema");
        CmdLineParser.Option urlO = cmdLineParser.addStringOption('l', "url");
        CmdLineParser.Option userO = cmdLineParser.addStringOption('u', "user");
        CmdLineParser.Option verboseO = cmdLineParser.addBooleanOption('v', "verbose");

        cmdLineParser.parse(args);
        String[] otherArgs = cmdLineParser.getRemainingArgs();
        if (otherArgs.length > 1) {
            throw new RAConfigException();
        } else if (otherArgs.length == 1) {
            propsFileName = otherArgs[0];
        }

        help = ((Boolean)cmdLineParser.getOptionValue(helpO, Boolean.FALSE)).booleanValue();
        inFileName = (String)cmdLineParser.getOptionValue(inputO);
        outFileName = (String)cmdLineParser.getOptionValue(outputO);
        password = (String)cmdLineParser.getOptionValue(passwordO);
        promptPassword = ((Boolean)cmdLineParser.getOptionValue(promptPasswordO, Boolean.FALSE)).booleanValue();
        schema = (String)cmdLineParser.getOptionValue(schemaO);
        url = (String)cmdLineParser.getOptionValue(urlO);
        user = (String)cmdLineParser.getOptionValue(userO);
        verbose = ((Boolean)cmdLineParser.getOptionValue(verboseO, Boolean.FALSE)).booleanValue();
    }

    public boolean help() {
        return help;
    }

    public String inFileName() {
        return inFileName;
    }

    public String outFileName() {
        return outFileName;
    }

    public String password() {
        return password;
    }

    public boolean promptPassword() {
        return promptPassword;
    }

    public String schema() {
        return schema;
    }

    public String url() {
        return url;
    }

    public String user() {
        return user;
    }

    public boolean verbose() {
        return verbose;
    }

    public String propsFileName() {
        return propsFileName;
    }
}
