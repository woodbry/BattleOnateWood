function loadForm(form){
		
    document.getElementById("form_id").innerHTML=form.form_ID;
    document.getElementById("submittor_name").innerHTML=form.submittor_name;
    document.getElementById("supervisor_name").innerHTML=form.supervisor_name;
    document.getElementById("event_name").innerHTML=form.event_name;
    document.getElementById("event_type").innerHTML=form.event_type;
    document.getElementById("grade_received").innerHTML=form.grade_received;
    document.getElementById("supervisor_approval").innerHTML=form.supervisor_approval;
    document.getElementById("event_cost").innerHTML=form.event_cost;
    document.getElementById("date_completed").innerHTML=form.date_completed;
}

function getForm(){
	console.log( "in get VG bananaphone!");
	let fid=document.getElementById("form_id").value;
	var xhr= new XMLHttpRequest();
	xhr.onreadystatechange= function() {
		console.log("in ORSC "+ xhr.readyState );
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			var f= JSON.parse(xhr.responseText);
			loadForm(f);
		}
    }
    //change link when you add to project
	xhr.open("GET","http://localhost:9090/TuitionReimbursementManagementSystem/DummyFormGetter?fid=" + fid,true);
	xhr.send();
}


function postForm(){
	console.log("in postForm");
	
	//let vg=document.getElementById("vgForm").submit;
	 var xhr= new XMLHttpRequest();
	xhr.onreadystatechange= function() {
		console.log("in ORSC "+ xhr.readyState );
	if(xhr.readyState==4 && xhr.status==200){
	console.log(xhr.responseText);
	}
}
//change link when you add to project
xhr.open("POST","http://localhost:9090/TuitionReimbursementManagementSystem/DummyFormGetter",true);
	var payload=jsonBuilder();
	xhr.send(payload);

}
function jsonBuilder() {
    var elements = document.getElementById("vgForm").elements;
    var obj ={};
    for(var i = 0 ; i < elements.length-1; i++){
        var item = elements.item(i);
        obj[item.name] = item.value;
        console.log(obj);   
    }
    var json= JSON.stringify(obj);
    console.log(json);
    return json;
}

window.onload= function() {
	console.log("in onload");
	document.getElementById("fidSubmitGet").addEventListener("click",getForm,false);
	document.getElementById("trmsFormSubmit").addEventListener("click", postForm,false);
}