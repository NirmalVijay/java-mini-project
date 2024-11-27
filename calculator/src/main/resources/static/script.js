let firstOperand = '';
let secondOperand = '';
let operator = '';
let isSecondOperand = false;

function appendNumber(number) {
    const display = document.getElementById('display');
    if (!isSecondOperand) {
        firstOperand += number;
        display.innerText = firstOperand;
    } else {
        secondOperand += number;
        display.innerText = secondOperand;
    }
}

function setOperator(op) {
    operator = op;
    isSecondOperand = true;
}

function clearDisplay() {
    firstOperand = '';
    secondOperand = '';
    operator = '';
    isSecondOperand = false;
    document.getElementById('display').innerText = '0';
}

function calculate() {
    if (!firstOperand || !secondOperand || !operator) return;

    const url = `/api/calculator/calculate?operand1=${firstOperand}&operand2=${secondOperand}&operator=${encodeURIComponent(operator)}`;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            document.getElementById('display').innerText = data.result;
            firstOperand = data.result.toString();
            secondOperand = '';
            operator = '';
            isSecondOperand = false;
        })
        .catch(err => alert('Error: ' + err.message));
}
