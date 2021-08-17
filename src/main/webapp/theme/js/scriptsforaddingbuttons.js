const ammoBoughtField = document.getElementById('ammoBought');

const addOneButton = document.getElementById('addOne');
const addTenButton = document.getElementById('addTen');
const addHundredButton = document.getElementById('addHundred');
const addThousandButton = document.getElementById('addThousand');

addOneButton.addEventListener('click', function(event){
        var ammoToAdd = 1;
        var ammoBought = Number(ammoBoughtField.value);
        var ammoToShow = ammoToAdd + ammoBought;
        ammoBoughtField.value = ammoToShow;
})

addTenButton.addEventListener('click', function(event){
        var ammoToAdd = 10;
        var ammoBought = Number(ammoBoughtField.value);
        var ammoToShow = ammoToAdd + ammoBought;
        ammoBoughtField.value = ammoToShow;
})

addHundredButton.addEventListener('click', function(event){
        var ammoToAdd = 100;
        var ammoBought = Number(ammoBoughtField.value);
        var ammoToShow = ammoToAdd + ammoBought;
        ammoBoughtField.value = ammoToShow;
})

addThousandButton.addEventListener('click', function(event){
        var ammoToAdd = 1000;
        var ammoBought = Number(ammoBoughtField.value);
        var ammoToShow = ammoToAdd + ammoBought;
        ammoBoughtField.value = ammoToShow;
})
