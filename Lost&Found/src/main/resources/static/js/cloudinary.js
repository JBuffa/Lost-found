$(document).ready(function() {
    
    $("#upload_widget_opener").click(function () {
    
        cloudinary.openUploadWidget({
    
        upload_preset : 'fnggqfiz', 
        cloud_name: 'dfwlfvd87',
        theme: 'white',
        multiple: true,
        max_image_width: 750,
        max_image_height: 500,
        max_files: 5,
        folder: 'LostFound/avisos',
        sources: [ 'local', 'url', 'facebook'], 
    }, function(error, result) {
        if (result && result !==[]){ 
            var url = result[0].secure_url ;
            $("form").find("#imagen_avisos").val(url);    
        }
       
        });
        
    });  
    
    
    $("#upload_widget_opener2").click(function () {
    
        cloudinary.openUploadWidget({
    
        upload_preset : 'fnggqfiz', 
        cloud_name: 'dfwlfvd87',
        theme: 'white',
        multiple: true,
        max_image_width: 750,
        max_image_height: 500,
        max_files: 5,
        folder: 'LostFound/mascota',
        sources: [ 'local', 'url', 'facebook'], 
    }, function(error, result) {
        if (result && result !==[]){ 
            var url = result[0].secure_url ;
            $("form").find("#imagen_mascota").val(url);    
        }
       
        });
        
    });  
   
    
    $("#upload_widget_opener3").click(function () {
        
        cloudinary.openUploadWidget({
    
        upload_preset : 'fnggqfiz', 
        cloud_name: 'dfwlfvd87',
        theme: 'white',
        multiple: true,
        max_image_width: 750,
        max_image_height: 500,
        max_files: 5,
        folder: 'LostFound/perdidos',
        sources: [ 'local', 'url', 'facebook'], 
    }, function(error, result) {
        if (result && result !==[]){ 
            var url = result[0].secure_url ;
            $("form").find("#imagen_perdidos").val(url);    
        }
       
        });
        
    });  

    $("#upload_widget_opener4").click(function () {
        
        cloudinary.openUploadWidget({
    
        upload_preset : 'fnggqfiz', 
        cloud_name: 'dfwlfvd87',
        theme: 'white',
        multiple: true,
        max_image_width: 750,
        max_image_height: 500,
        max_files: 5,
        folder: 'LostFound/refugio',
        sources: [ 'local', 'url', 'facebook'], 
    }, function(error, result) {
        if (result && result !==[]){ 
            var url = result[0].secure_url ;
            $("form").find("#imagen_refugio").val(url);    
        }
       
        });
        
    });  
    
    
    $("#upload_widget_opener5").click(function () {
        
        cloudinary.openUploadWidget({
    
        upload_preset : 'fnggqfiz', 
        cloud_name: 'dfwlfvd87',
        theme: 'white',
        multiple: true,
        max_image_width: 750,
        max_image_height: 500,
        max_files: 5,
        folder: 'LostFound/usuario',
        sources: [ 'local', 'url', 'facebook'], 
    }, function(error, result) {
        if (result && result !==[]){ 
            var url = result[0].secure_url ;
            $("form").find("#imagen_usuario").val(url);    
        }
       
        });
        
    });  
    
    
});