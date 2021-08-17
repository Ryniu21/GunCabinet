const ammoShootOnTrainingField = document.getElementById('ammoShootOnTraining');

const shootOneButton = document.getElementById('shootOne');
const shootTenButton = document.getElementById('shootTen');
const shootHundredButton = document.getElementById('shootHundred');
const shootThousandButton = document.getElementById('shootThousand');

shootOneButton.addEventListener('click', function(event){
        var ammoToAdd = 1;
        var ammoShootOnTraining = Number(ammoShootOnTrainingField.value);
        var ammoToShow = ammoToAdd + ammoShootOnTraining;
        ammoShootOnTrainingField.value = ammoToShow;
        console.log(ammoShootOnTraining)
})

shootTenButton.addEventListener('click', function(event){
        var ammoToAdd = 10;
        var ammoShootOnTraining = Number(ammoShootOnTrainingField.value);
        var ammoToShow = ammoToAdd + ammoShootOnTraining;
        ammoShootOnTrainingField.value = ammoToShow;
        console.log(ammoShootOnTraining)
})

shootHundredButton.addEventListener('click', function(event){
        var ammoToAdd = 100;
        var ammoShootOnTraining = Number(ammoShootOnTrainingField.value);
        var ammoToShow = ammoToAdd + ammoShootOnTraining;
        ammoShootOnTrainingField.value = ammoToShow;
        console.log(ammoShootOnTraining)
})

shootThousandButton.addEventListener('click', function(event){
        var ammoToAdd = 1000;
        var ammoShootOnTraining = Number(ammoShootOnTrainingField.value);
        var ammoToShow = ammoToAdd + ammoShootOnTraining;
        ammoShootOnTrainingField.value = ammoToShow;
        console.log(ammoShootOnTraining)
})


