function TypeControl() {
    var type = document.getElementById("regiType");
    var facultyInput = document.getElementById("facultyInput");
    var departmentInput = document.getElementById("departmentInput");
    var batchInput = document.getElementById("batchInput");
    var sessionInput = document.getElementById("sessionInput");
    var dojInput = document.getElementById("dojInput");
    var sidInput = document.getElementById("sidInput");
    var designationInput = document.getElementById("designationInput");
    var usernameInput = document.getElementById("usernameInput");
    var passwordInput = document.getElementById("passwordInput");
    var confirmPasswordInput = document.getElementById("confirmPasswordInput");
    var submitInput = document.getElementById("submitInput");

    if (type.value == "Student") {
        facultyInput.innerHTML = "";
        departmentInput.innerHTML = "";
        batchInput.innerHTML = "";
        sessionInput.innerHTML = "";
        dojInput.innerHTML = "";
        sidInput.innerHTML = "";
        designationInput.innerHTML = "";
        usernameInput.innerHTML = "";
        passwordInput.innerHTML = "";
        confirmPasswordInput.innerHTML = "";
        submitInput.innerHTML = "";

        facultyInput.innerHTML = '<select class="" name="faculty" id="faculty" required="true" onchange="Department();"><option selected="true" disabled="true">Select</option></select>';
        Faculty();
        departmentInput.innerHTML = '<select class="" name="dept" id="department" required="true" onchange="Batch();"><option selected="true" disabled="true">Select</option></select>';
        batchInput.innerHTML = '<select class="" name="batch" id="batch" required="true" onchange="Session();"><option selected="true" disabled="true">Select</option></select>';
        sessionInput.innerHTML = '<select class="" name="session" id="session" required="true"><option selected="true" disabled="true">Select</option></select>';
        dojInput.innerHTML = '<div class="input-group"><div class="input-group-addon" style="padding-left: 10px; padding-right: 10px; padding-top: 16px;">Join Date</div><input type="date" class="form-control" name="doj" id="doj" required="true"></div>';
        SID();
        usernameInput.innerHTML = '<input type="text" name="username" id="username" placeholder="Enter Username" required="true">';
        passwordInput.innerHTML = '<input type="Password" name="password" id="password" placeholder="Password" required="true">';
        confirmPasswordInput.innerHTML = '<input type="Password" name="confirmPassword" id="confirmPassword" placeholder="Confirm password" required="true">';
        submitInput.innerHTML = '<button type="submit" class="boxed_btn_orange">Sign Up</button>';
    }
    else if (type.value == "Teacher") {
        facultyInput.innerHTML = "";
        departmentInput.innerHTML = "";
        batchInput.innerHTML = "";
        sessionInput.innerHTML = "";
        dojInput.innerHTML = "";
        sidInput.innerHTML = "";
        designationInput.innerHTML = "";
        usernameInput.innerHTML = "";
        passwordInput.innerHTML = "";
        confirmPasswordInput.innerHTML = "";
        submitInput.innerHTML = "";

        facultyInput.innerHTML = '<select class="" name="faculty" id="faculty" required="true" onchange="Department();"><option selected="true" disabled="true">Select</option></select>';
        Faculty();
        departmentInput.innerHTML = '<select class="" name="dept" id="department" required="true" onchange="Batch();"><option selected="true" disabled="true">Select</option></select>';
        dojInput.innerHTML = '<div class="input-group"><div class="input-group-addon" style="padding-left: 10px; padding-right: 10px; padding-top: 16px;">Join Date</div><input type="date" class="form-control" name="doj" id="doj" required="true"></div>';
        Designation();
        usernameInput.innerHTML = '<input type="text" name="username" id="username" placeholder="Enter Username" required="true">';
        passwordInput.innerHTML = '<input type="Password" name="password" id="password" placeholder="Password" required="true">';
        confirmPasswordInput.innerHTML = '<input type="Password" name="confirmPassword" id="confirmPassword" placeholder="Confirm password" required="true">';
        submitInput.innerHTML = '<button type="submit" class="boxed_btn_orange">Sign Up</button>';
    }
    else {
        facultyInput.innerHTML = "";
        departmentInput.innerHTML = "";
        batchInput.innerHTML = "";
        sessionInput.innerHTML = "";
        dojInput.innerHTML = "";
        sidInput.innerHTML = "";
        designationInput.innerHTML = "";
        usernameInput.innerHTML = "";
        passwordInput.innerHTML = "";
        confirmPasswordInput.innerHTML = "";
        submitInput.innerHTML = "";
    }
}


/*----------------------------------------------------------------------------------------------------------------------------------------------------------*/

function Faculty () {
    var faculty = document.getElementById("faculty");
    var type = document.getElementById("regiType");
    faculty.innerHTML = "";

    if(type.value == "Teacher" || type.value == "Student") {
        var FacultyArray = [
            "Select Faculty",
            "Engineering",
            "Science",
            "Life Science",
            "Business Studies",
            "Social Science"
        ];
    }
    else {
        var FacultyArray = ["Select"];
    }

    for (var i in FacultyArray) {
        var newOption = document.createElement("option");
        newOption.value = FacultyArray[i];
        newOption.innerHTML = FacultyArray[i];
        faculty.options.add(newOption);
    }
}

function Department() {
    var faculty = document.getElementById("faculty");
    var department = document.getElementById("department");
    department.innerHTML = "";

    if (faculty.value == "Engineering") {
        var deptArray = [
            "Select Department",
            "CSE",
            "ICT",
            "TE"
        ];
    }
    else if (faculty.value == "Science") {
        var deptArray = [
            "Select Department",
            "Chemistry",
            "Mathematics",
            "Physics",
            "Statistics"
        ];
    }
    else if (faculty.value == "Life Science") {
        var deptArray = ["Select Department",
            "Pharmacy",
            "BGE",
            "BMB",
            "FTNS",
            "ESRM",
            "CPS"
        ];
    }
    else if (faculty.value == "Business Studies") {
        var deptArray = [
            "Select Department",
            "Business Administration",
            "Management",
            "Accounting"
        ];
    }
    else if (faculty.value == "Social Science") {
        var deptArray = [
            "Select Department",
            "Economics"
        ];
    }
    else {
        var deptArray = ["Select"];
    }


    for(var i in deptArray) {
        var newOption = document.createElement("option");
        newOption.value = deptArray[i];
        newOption.innerHTML = deptArray[i];
        department.options.add(newOption);
    }

}

function Batch () {
    var type = document.getElementById("regiType");
    var department = document.getElementById("department");
    var batch = document.getElementById("batch");
    batch.innerHTML = "";

    if (type.value == "Student") {
        if (department.value == "CSE" || department.value == "ICT" || department.value == "ESRM" || department.value == "CPS") {
            var totalNumberOfBatch = 17;
            var batchArray = batchGenarator(totalNumberOfBatch);
        }

        else if (department.value == "TE") {
            var totalNumberOfBatch = 15;
            var batchArray = batchGenarator(totalNumberOfBatch);
        }

        else if (department.value == "Chemistry" || department.value == "Mathematics" || department.value == "Physics" || department.value == "Statistics") {
            var totalNumberOfBatch = 10;
            var batchArray = batchGenarator(totalNumberOfBatch);
        }

        else {
            var batchArray = ["Select"];
        }
    }

    else {
        var batchArray = ["Select"];
    }


    for(var i in batchArray) {
        var newOption = document.createElement("option");
        newOption.value = batchArray[i];
        newOption.innerHTML = batchArray[i];
        batch.options.add(newOption);
    }
}

function Session () {
    var type = document.getElementById("regiType");
    var department = document.getElementById("department");
    var session = document.getElementById("session");
    session.innerHTML = "";

    if (type.value == "Student") {
        if (department.value == "CSE" || department.value == "ICT" || department.value == "ESRM" || department.value == "CPS") {
            var totalNumberOfBatch = 17;
            var sessionArray = sessionGenerator(totalNumberOfBatch);
        }

        else if (department.value == "TE") {
            var totalNumberOfBatch = 15;
            var sessionArray = sessionGenerator(totalNumberOfBatch);
        }

        else if (department.value == "Chemistry" || department.value == "Mathematics" || department.value == "Physics" || department.value == "Statistics") {
            var totalNumberOfBatch = 10;
            var sessionArray = sessionGenerator(totalNumberOfBatch);
        }

        else {
            var sessionArray = ["Select"];
        }
    }

    else {
        var sessionArray = ["Select"];
    }


    for(var i in sessionArray) {
        var newOption = document.createElement("option");
        newOption.value = sessionArray[i];
        newOption.innerHTML = sessionArray[i];
        session.options.add(newOption);
    }
}

function SID() {
    var department = document.getElementById("department");
    var type = document.getElementById("regiType");
    var sidInput = document.getElementById("sidInput");

    if (type.value == "Student") {
        var idPrefix = "ID";

        if (department.value == "CSE") {
            idPrefix = "CE";
        }
        else if (department.value == "ICT") {
            idPrefix = "IT";
        }
        else if (department.value == "TE") {
            idPrefix = "TE";
        }
        else if (department.value == "Mathematics") {
            idPrefix = "MATH";
        }
        else if (department.value == "Chemistry") {
            idPrefix = "CHEM";
        }
        else if (department.value == "Physics") {
            idPrefix = "PHY";
        }
        else if (department.value == "Statistics") {
            idPrefix = "STAT";
        }
        else if (department.value == "Pharmacy") {
            idPrefix = "PHAR";
        }
        else if (department.value == "BGE") {
            idPrefix = "BGE";
        }
        else if (department.value == "BMB") {
            idPrefix = "BMB";
        }
        else if (department.value == "FTNS") {
            idPrefix = "FTNS";
        }
        else if (department.value == "ESRM") {
            idPrefix = "ESRM";
        }
        else if (department.value == "CPS") {
            idPrefix = "CPS";
        }
        else if (department.value == "Business Administration") {
            idPrefix = "BBA";
        }
        else if (department.value == "Management") {
            idPrefix = "MAN";
        }
        else if (department.value == "Accounting") {
            idPrefix = "ACC";
        }
        else if (department.value == "Economics") {
            idPrefix = "ECO";
        }

        sidInput.innerHTML = '<div class="input-group"><div class="input-group-addon" style="padding-left: 10px; padding-right: 10px; padding-top: 16px;" id="sidPrefix">'+idPrefix+'</div><input type="text" class="form-control" name="sid" id="sid" placeholder="Enter your Student ID" required="true"/></div>';

    }


    else {

    }
}

function Designation() {
    var type = document.getElementById("regiType");
    var designationInput = document.getElementById("designationInput");
    designationInput.innerHTML = "";

    if (type.value == "Teacher") {
        var designationArray = [
            "Select Designation",
            "Lecturer",
            "Assistant Professor",
            "Associate Professor",
            "Professor"
        ];
    }
    else {
        var designationArray = ["Select"];
    }


    designationInput.innerHTML = '<select class="" name="designation" id="designation" required="true""></select>';


    for(var i in designationArray) {
        var newOption = document.createElement("option");
        newOption.value = designationArray[i];
        newOption.innerHTML = designationArray[i];
        designation.options.add(newOption);
    }
}


function batchGenarator (totalNumberOfBatch) {
    var batchArray = ["Select Batch"];
    for (var i=1; i<=totalNumberOfBatch; i++) {
        if (i%10 == 1 && i!=11) {
            var batchNo = i+"ST";
        }
        else if (i%10 == 2 && i!==12) {
            var batchNo = i+"ND";
        }
        else if (i%10 == 3 && i!= 13) {
            var batchNo = i+"RD";
        }
        else {
            var batchNo = i+"TH";
        }

        batchArray[i] = batchNo;
    }

    return batchArray;
}

function sessionGenerator (totalNumberOfBatch) {
    var sessionArray = ["Select Session"];
    for (var i=totalNumberOfBatch; i>=1; i--) {
        var s1 = 2002 + i + "";
        var s2 = 3 + i + "";
        if (s2.length == 1) {s2 = "0"+s2;}
        var session = s1+"-"+s2;

        sessionArray[totalNumberOfBatch-i+1] = session;
    }

    return sessionArray;
}