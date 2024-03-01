package br.com.kualit;


import br.com.kualit.service.OperationGenerator;

public class App {
    public static void main(String[] args) {
        OperationGenerator operationGenerator = new OperationGenerator();
        operationGenerator.generateOperation();
    }
}
