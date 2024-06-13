
function toggleObjectiveDropdown() {
    var checkbox = document.getElementById('checkbox');
    var objectiveDropdown = document.getElementById('objectiveDropdown');
    if (checkbox.checked) {
        objectiveDropdown.classList.remove('d-none');
    } else {
        objectiveDropdown.classList.add('d-none');
    }
}