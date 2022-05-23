
$(".edit").on("click", function (){
    alert("you clicked a button !!!")
    let postId = $(this).attr("data-id")
    window.location = "/post/" + postId + "/edit";
});

