$(document).ready(function () {
    
    
    $(".day_select").change(function(){
       for(var i = 1; i <= 7; i++){
           $('#daily\\:input' + i).val($('#select' + i).val());
       }
    });
    
   
    
});


