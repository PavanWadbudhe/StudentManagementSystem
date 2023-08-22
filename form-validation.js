/**
 * 
 */
function formValidation(){
	var rno=document.registration.rno;
	var sname=document.registration.sname;
	var ubr=document.registration.br;
	var mar=document.registration.mar;
	var hindi=document.registration.hindi;
	var eng=document.registration.eng;
	var math=document.registration.math;
	var sci=document.registration.sci;
	var sosci=document.registration.sosci;
	if(rno_validation(rno,10)){
		if(allLetter(sname)){
			if(branchselect(ubr)){
				if(allnumeric(mar,hindi,eng,math,sci,sosci)){					
				}
			}
		}
	}else{
		return false;
	}
}

function rno_validation(rno,mx){
	var rno_len=rno.value.length;
	if(rno_len>mx || rno_len<mx){
		alert("RollNo should not be empty / length must be "+mx);
		rno.focus();
		return false;
	}
	return true;
}

function allLetter(sname){
	var letters=/^[A-Za-z ]+$/;
	if(sname.value.match(letters)){
		return true;
	}else{
		alert("Username must have alphabet characters only");
		sname.focus();
		return false;
	}
}
function branchselect(ubr){
	if(ubr.value == "Default"){
		alert("Select your Branch ");
		ubr.focus();
		return false;
	}else{
		return true;
	}
}
function allnumeric( mar , hindi, eng,  math, sci, sosci){
	
	const  sub=[mar , hindi, eng,  math, sci, sosci];
	var numbers = /^[0-9]+$/;
	for(var i=0;i<=sub.length();i++){
		if(sub.value.match(numbers)){
			return true;
		}else{
			alert('Inter Valid number Enter 0 to 100');
			sub.focus();
			return false;
		}
	}
}
