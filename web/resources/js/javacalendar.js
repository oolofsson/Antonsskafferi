$(function(){
    
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
    
    $(".accept_btn").click(function(){
       
    });
      
});
