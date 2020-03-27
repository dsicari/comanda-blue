package br.com.nextgen2020.comandablue.controller;

import br.com.nextgen2020.comandablue.Service.ComandaService;
import br.com.nextgen2020.comandablue.model.entidade.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.nextgen2020.comandablue.model.entidade.Comanda;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class ComandaController {

    @Autowired
    private ComandaService comandaService;


    private static final Logger log = LoggerFactory.getLogger(ComandaService.class);

    @PostMapping(path= "/estabelecimento/{idEstabelecimento}/mesas/{idMesa}/comandas/abrir", consumes = "application/json", produces = "application/json")
    @Transactional
    public Comanda abrir(@PathVariable(value="idEstabelecimento") Long idEstabelecimento, @PathVariable(value="idMesa") Long idMesa, @RequestHeader(name = "COMANDA-BLUE-CLIENTE", required = true) String emailCliente){

        return comandaService.abrir(idEstabelecimento, idMesa, emailCliente);
    }

    @PostMapping(path= "/estabelecimento/{idEstabelecimento}/mesas/{idMesa}/comandas/{idComanda}/pedir", consumes = "application/json", produces = "application/json")
    public Comanda fazerPedido(@PathVariable(value="idEstabelecimento") Long idEstabelecimento, @PathVariable(value="idMesa") Long idMesa, @RequestBody List<Pedido> itemPedido, @PathVariable(value="idComanda") Long idComanda, @RequestHeader(name = "COMANDA-BLUE-CLIENTE", required = true) String emailCliente){
        log.info(itemPedido.toString());
        return comandaService.fazerPedido(idComanda, itemPedido, emailCliente, idEstabelecimento, idMesa);
    }
}
