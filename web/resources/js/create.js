$(document).ready(function () {
   /*$("#VisaDagens").change(function(){
        switch(new Date().getDay()){
            case 1:
                $("#VisaDagens").val($("Dagens Lunch: "+"#monday").val());
                break;
            case 2:
                $("#VisaDagens").val($("#thuesday").val());  
                break;
            case 3:
                $("#VisaDagens").val($("#monday").val());
                break;
            case 4:
                $("#VisaDagens").val($("#monday").val());
                break;
            case 5:
                $("#VisaDagens").val($("#monday").val());
                break;
         };
     });*/
    
    
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
    $('.parallax').parallax();
    $('.scrollspy').scrollSpy();
    $('.tabs-wrapper .row').pushpin({ top: $('.tabs-wrapper').offset().top });
    
});




