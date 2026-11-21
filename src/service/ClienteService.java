package service;

import model.Cliente;
import util.Console;
import util.Validaciones;
import repository.IClienteRepository;

public class ClienteService {

    //Inversión de control: uso de interfaces
    private IClienteRepository clienteRepo;

    public ClienteService(IClienteRepository repo) {
        this.clienteRepo = repo;
    }

    // Bug corregido: DNI obligatorio y de 8 dígitos numéricos
    public void registrarCliente(String dni, String nombre, String tipo) {

        if (dni == null || !dni.matches("\\d{8}")) {
            System.out.println("ERROR: Cliente inválido");
            return;
        }

        Cliente cliente = new Cliente(dni, nombre, tipo);
        clienteRepo.guardar(cliente);
        Console.info("Cliente registrado: " + nombre);
    }

    public Cliente buscarCliente(String dni) {
        return clienteRepo.buscarPorDni(dni);
    }
}
