$(document).ready(function () {
    
    
    $("#delete_drink").change(function(){
        $('#delete_drink_form\\:input_drink').val($('#delete_drink').val());
    });
    
    $("#delete_dish").change(function(){
        $('#delete_dish_form\\:input_dish').val($('#delete_dish').val());
    });
    
    $('.day_select').change(function(){
        for(var i = 1; i <= 7; i++){
           $('#daily_special_form\\:input' + i).val($('#select' + i).val());
        }
    });
    
});


