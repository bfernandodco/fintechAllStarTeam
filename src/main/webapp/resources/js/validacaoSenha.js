function validarSenha(event){
    event.preventDefault();

    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;
    const confirmarSenha = document.getElementById('confirmaSenha').value;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const senhaRegex = /^(?=.*[a-zA-Z])(?=.*\d)[A-Za-z\d]{6,}$/;

    if (!emailRegex.test(email)) {
        alert('Por favor, insira um email válido.');
        return false;
    }

    if (!senhaRegex.test(senha)) {
        alert('A senha deve ter no mínimo 6 caracteres e combinar letras e números.');
        return false;
    }

    if (senha !== confirmarSenha) {
        alert('As senhas não coincidem.');
        event.target.submit();
        return false;
    }

    // Se tudo estiver correto, o formulário pode ser enviado
    alert('Formulário enviado com sucesso!');
    return true;
}

document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('form');
    form.addEventListener('submit', validarSenha);
});