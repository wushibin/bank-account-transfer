package ddd.saga.example.transfer.command;

import ddd.saga.example.common.domain.DomainCommand;

public class CommandContext {
    static public void sendCommand(DomainCommand command){
        // send the command and find the corresponding command handle to process the command
    }
}
