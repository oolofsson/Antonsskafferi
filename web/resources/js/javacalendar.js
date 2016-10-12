$(function(){
    
    $("#adminknapp").click(function(){
       window.location.href = "create.xhtml"; 
    });
    
    $(".event1_select").change(function(){
        var event1str = $(".event1_select").val();
        var event1arr = event1str.split(".");
        $(".event1_id_input").val(event1arr[0]);
        $(".sender_id_input").val(event1arr[1]);
    });
    
    $(".event2_select").change(function(){
        var event2str = $(".event2_select").val();
        var event2arr = event2str.split(".");
        $(".event2_id_input").val(event2arr[0]);
        $(".receiver_id_input").val(event2arr[1]);
    });
    
    
    $(".waiter_select").change(function(){
        var waiterStr = $(".waiter_select").val();
        var waiterArr = waiterStr.split(".");
        $(".waiter_id_input").val(waiterArr[0]);
        $(".event_text_input").val(waiterArr[1]);
        $(".color_input").val(getColorCode(waiterArr[0])); //Generate color
        $("#datepicker").show();
    });
    
    //Datepicker init
    $( "#datepicker" ).datepicker({ 
      dayNamesMin: ['M&aring', 'Ti', 'On', 'To', 'Fr', 'L&ouml', 'S&ouml'],
      monthNames: ['Januari', 'Februari', 'Mars', 'April', 'Maj', 'Juni', 'Juli', 'Augusti', 'September','Oktober', 'November', 'December']
      
    });
    
    $('#datepicker').datepicker('option', 'dateFormat', 'yy-mm-dd');
    $(".event_time_select").hide(); //Time select hidden before date is selected
    $("#datepicker").hide();
    $('.event_submit').prop('disabled', true);
    
    $("#datepicker").change(function(){
        //$(".event_start_date_input").val($("#datepicker").val());
        //$(".event_end_date_input").val($("#datepicker").val());
        $(".event_time_select").show();
        
    });
    
    $(".event_time_select").change(function(){
       
       var timeStr = $(".event_time_select").val();
       var timeArr = timeStr.split(".");
        
       $(".event_start_date_input").val($("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' }).val() + " " + timeArr[0]);
       $(".event_end_date_input").val($("#datepicker").datepicker({ dateFormat: 'yy-mm-dd' }).val() + " " + timeArr[1]);
       $('.event_submit').prop('disabled', false);
       
    });
    
});

getColorCode = function(id){
    var colorCode = "#";
    for(var i = 0; i < 6; i++){
        if(i % 2 == 0)
            colorCode += Number(id) * (i + 1);
        else
            colorCode += Number(id) + 4 * i;
    }
    return colorCode.substr(0, 7);
}