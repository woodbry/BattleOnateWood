function loadForm(form){
		
    document.getElementById("formId").innerHTML=form.formId;
    document.getElementById("empId").innerHTML=form.empId;
    document.getElementById("supervisorName").innerHTML=form.supervisorName;
    document.getElementById("eventName").innerHTML=form.eventName;
	document.getElementById("eventType").innerHTML=form.eventType;
	document.getElementById("eventCost").innerHTML=form.eventCost;
    document.getElementById("approvedByDS").innerHTML=form.approvedByDS;
	document.getElementById("approvedByDH").innerHTML=form.approvedByDH;
	document.getElementById("approvedByBC").innerHTML=form.approvedByBC;
    document.getElementById("dateCompleted").innerHTML=form.dateCompleted;
}

function getForm(){
	console.log("in get Form");
	let fid=document.getElementById("formId").value;
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
	xhr.open("GET","http://localhost:9090/TuitionReimbursementManagementSystem/DummyFormGetter?fid="+fid,true);
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
    var elements = document.getElementById("trmsForm").elements;
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