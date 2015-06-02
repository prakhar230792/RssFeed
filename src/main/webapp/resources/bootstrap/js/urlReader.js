$(document).ready(function(){
  $("#urlFeedButtons").click(function(){
    if($('#urlText').val() =='')
    {
      alert("Please Enter a URL"); 
    }
    else
    {
      $.post("/",
      {
        action:"fetchData",
        feedUrl:$("#urlText").val()
      },
      function(data){
        $("#urlText").prop('disabled',true);
        if(data == "NewUser")
        {
          $("#activityButtons").hide();
          $("#newUserForm").show();
        }
        else
        {
          $("#buildTable").find("tr:gt(0)").remove();
          appBuilds = data['appBuilds']
          for(var key in appBuilds)
          {
            var comment = appBuilds[key].comment
            var link = appBuilds[key].appLink
            var tableRow = '<tr><td><a href = "'+link+'"">'+key+'</a></td><td>'+comment+'</td></tr>'
            $("#buildTable tr:first").after(tableRow);
          }
          $("#buildTable td").show();
          $("#buildTable th").show();
          $("#activityButtons").show();
          $("#editDetails").show();
          $("#newUserForm").hide();
          $("#appLink").hide();
        }
      })
      .fail(function() {
        alert('Request could not be completed');
      });
    }
  });
  
});
