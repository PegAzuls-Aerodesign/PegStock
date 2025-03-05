package com.pegazuls.aerodesign.PegStock.commands;

import com.pegazuls.aerodesign.PegStock.model.entities.CommandEntity;
import com.pegazuls.aerodesign.PegStock.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CommandInvoker {

    @Autowired
    private CommandRepository repository;


    public void execute(Command command) {
        command.execute();
        CommandEntity commandEntity = new CommandEntity(
                command.getName(),
                command.getQuantity(),
                command.getMaterial().getName()
        );
        repository.save(commandEntity);
    }

    public void generateReport() {
        List<CommandEntity> commands = repository.findAll();
        String fileName = "report.csv";
        String header = "Acao, Material, Quantidade, Data\n";
        StringBuilder content = new StringBuilder(header);
        commands.forEach(c -> {
            content.append(c.getCommandName())
                    .append("; ")
                    .append(c.getMaterialName())
                    .append("; ")
                    .append(c.getQuantity())
                    .append("; ")
                    .append(c.getExecutedAt())
                    .append("\n");
        });
        try {
            Files.writeString(Paths.get(fileName), content.toString());;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
