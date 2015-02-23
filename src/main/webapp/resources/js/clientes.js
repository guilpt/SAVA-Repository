Clientes = function() {};

limparDivMensagemClientes = function() {
    setTimeout( function() { $('#divMessagesCliente').html(''); }, 5000);
};

abrirModalBuscarCliente = function() {
    $('#dialog-buscar-cliente').dialog();
};



