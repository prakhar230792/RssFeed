$(document).ready(function(){
  $("#urlFeedButtons").click(function(){
    if($('#urlText').val() =='')
    {
      alert("Please Enter a URL"); 
    }
    else
    {
      $.post("/fetchData",
      {
        feedUrl:$("#urlText").val()
      },
      function(data){
        $( "#rssFeed" ).empty();
        $( "#rssFeed" ).append( data['link'] );
        console.log(data['link']);
      })
      .fail(function() {
        alert('Request could not be completed');
      });
    }
  });
  
});
