
function toggleObjectiveDropdown() {
    var checkbox = document.getElementById('checkbox');
    var objectiveDropdown = document.getElementById('objectiveDropdown');
    if (checkbox.checked) {
        objectiveDropdown.classList.remove('d-none');
    } else {
        objectiveDropdown.classList.add('d-none');
    }
}

function setCurrentDateTime() {
    const now = new Date();
    const year = now.getFullYear();
    const month = String(now.getMonth() + 1).padStart(2, '0');
    const day = String(now.getDate()).padStart(2, '0');
    const hours = String(now.getHours()).padStart(2, '0');
    const minutes = String(now.getMinutes()).padStart(2, '0');

    const formattedDateTime = `${year}-${month}-${day}T${hours}:${minutes}`;
    document.getElementById('dataHora').value = formattedDateTime;
}

// Chama a função para definir a data e hora atual quando a página carrega
window.onload = setCurrentDateTime;