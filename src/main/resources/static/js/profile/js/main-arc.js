function AddCourse () {
	var addCourseInput = document.getElementById('addCourseInput');
	var searchCourseInput = document.getElementById('searchCourseInput');

	searchCourseInput.innerHTML = "";
	addCourseInput.innerHTML = '<form th:action="@{/}" method="POST">'+
			'<div class="row">'+
				'<div class="col-sm-12 col-md-2">'+
					'<select class="form-control" id="department" name="department" onchange="Session();" required>'+
						'<option option="dept">Dept</option>'+
					'</select>'+
				'</div>'+
				'<div class="col-sm-12 col-md-2">'+
					'<select class="form-control" id="session" name="session" required>'+
						'<option value="session">Session</option>'+
					'</select>'+
				'</div>'+
				'<div class="col-sm-12 col-md-3">'+
					'<select class="form-control" id="semester" name="semester" onchange="Course();" required>'+
						'<option option="semester">Semester</option>'+
						'<option value="1st">1st</option>'+
						'<option value="2nd">2nd</option>'+
						'<option value="3rd">3rd</option>'+
						'<option value="4th">4th</option>'+
						'<option value="5th">5th</option>'+
						'<option value="6th">6th</option>'+
						'<option value="7th">7th</option>'+
						'<option value="8th">8th</option>'+
					'</select>'+
				'</div>'+
				'<div class="col-sm-12 col-md-3">'+
					'<select class="form-control" id="course" name="courseCode" required>'+
						'<option value="course">Course</option>'+
					'</select>'+
				'</div>'+
				'<div class="col-sm-12 col-md-2">'+
					'<button class="btn btn-course" type="submit" name="button" value="add">Add</button>'+
				'</div>'+
			'</div>'+
		'</form>';

	Department();
}

function SearchCourse () {
	var searchCourseInput = document.getElementById('searchCourseInput');
	var addCourseInput = document.getElementById('addCourseInput');

	addCourseInput.innerHTML = "";
	searchCourseInput.innerHTML = '<form th:action="@{/}" method="POST">'+
			'<div class="row">'+
				'<div class="col-sm-12 col-md-4">'+
					'<select class="form-control" id="searchType" name="searchType" onchange="SearchCourseType();" required>'+
						'<option value="searchType">Search Type</option>'+
						'<option value="department">Department</option>'+
						'<option value="courseCode">Course Code</option>'+
					'</select>'+
				'</div>'+
				'<div class="col-sm-12 col-md-4" id="searchInput">'+
					'<select class="form-control" required>'+
						'<option>Select</option>'+
					'</select>'+
				'</div>'+
				'<div class="col-sm-12 col-md-4">'+
					'<button class="btn btn-course" type="submit" name="button" value="search">Search</button>'+
				'</div>'+
			'</div>'+
		'</form>';
}

function AddCourseStd () {
	var addCourseInput = document.getElementById('addCourseInput');
	var searchCourseInput = document.getElementById('searchCourseInput');

	searchCourseInput.innerHTML = "";
	addCourseInput.innerHTML = '<form th:action="@{/}" method="POST">'+
			'<div class="row">'+
				'<div class="col-sm-12 col-md-3">'+
					'<select class="form-control" name="session" id="session" required>'+
						'<option value="session">Session</option>'+
					'</select>'+
				'</div>'+
				'<div class="col-sm-12 col-md-3">'+
					'<select class="form-control" name="semester" id="semester" onchange="CourseStd();" required>'+
						'<option option="semester">Semester</option>'+
						'<option value="1st">1st</option>'+
						'<option value="2nd">2nd</option>'+
						'<option value="3rd">3rd</option>'+
						'<option value="4th">4th</option>'+
						'<option value="5th">5th</option>'+
						'<option value="6th">6th</option>'+
						'<option value="7th">7th</option>'+
						'<option value="8th">8th</option>'+
					'</select>'+
				'</div>'+
				'<div class="col-sm-12 col-md-3">'+
					'<select class="form-control" name="course" id="course" required>'+
						'<option value="course">Course</option>'+
					'</select>'+
				'</div>'+
				'<div class="col-sm-12 col-md-3">'+
					'<button class="btn btn-course" type="submit" name="button" value="add">Add</button>'+
				'</div>'+
			'</div>'+
		'</form>';

	SessionStd();
}

function SearchCourseStd () {
	var searchCourseInput = document.getElementById('searchCourseInput');
	var addCourseInput = document.getElementById('addCourseInput');

	addCourseInput.innerHTML = "";
	searchCourseInput.innerHTML = '<form th:action="@{/}" method="POST">'+
			'<div class="row">'+
				'<div class="col-sm-12 col-md-4">'+
					'<select class="form-control" name="searchType" id="searchType" onchange="SearchCourseTypeStd();" required>'+
						'<option value="searchType" disabled selected>Search Type</option>'+
						'<option value="semester">Semester</option>'+
						'<option value="courseCode">Course Code</option>'+
					'</select>'+
				'</div>'+
				'<div class="col-sm-12 col-md-4" id="searchInput">'+
					'<select class="form-control" onchange="SearchCourseTypeStd();" required>'+
						'<option>Select</option>'+
					'</select>'+
				'</div>'+
				'<div class="col-sm-12 col-md-4">'+
					'<button class="btn btn-course" type="submit" name="button" value="search">Search</button>'+
				'</div>'+
			'</div>'+
		'</form>';
}


function Department() {
	var department = document.getElementById("department");
	department.innerHTML = "";

	var deptArray = [
		"Dept",
		"CSE",
		"ICT",
		"TE",
		"Chemistry",
		"Mathematics",
		"Physics",
		"Statistics",
		"Pharmacy",
		"BGE",
		"BMB",
		"FTNS",
		"ESRM",
		"CPS",
		"Business Administration",
		"Management",
		"Accounting",
		"Economics"
	];

	for(var i in deptArray) {
		var newOption = document.createElement("option");
		newOption.value = deptArray[i];
		newOption.innerHTML = deptArray[i];
		department.options.add(newOption);
	}
}

function Semester() {
	var semester = document.getElementById("semester");
	semester.innerHTML = "";

	var semesterArray = [
		"Semester",
		"1st",
		"2nd",
		"3rd",
		"4th",
		"5th",
		"6th",
		"7th",
		"8th"
	];

	for(var i in semesterArray) {
		var newOption = document.createElement("option");
		newOption.value = semesterArray[i];
		newOption.innerHTML = semesterArray[i];
		semester.options.add(newOption);
	}
}

function Session () {
	var department = document.getElementById("department");
	var session = document.getElementById("session");
	session.innerHTML = "";

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
		var sessionArray = ["Session"];
	}


	for(var i in sessionArray) {
		var newOption = document.createElement("option");
		newOption.value = sessionArray[i];
		newOption.innerHTML = sessionArray[i];
		session.options.add(newOption);
	}
}

function SessionStd () {
	var department = document.getElementById("department").firstChild.nodeValue;;
	var session = document.getElementById("session");
	session.innerHTML = "";

	if (department == "CSE" || department == "ICT" || department == "ESRM" || department == "CPS") {
		var totalNumberOfBatch = 17;
		var sessionArray = sessionGenerator(totalNumberOfBatch);
	}

	else if (department == "TE") {
		var totalNumberOfBatch = 15;
		var sessionArray = sessionGenerator(totalNumberOfBatch);
	}

	else if (department == "Chemistry" || department == "Mathematics" || department == "Physics" || department == "Statistics") {
		var totalNumberOfBatch = 10;
		var sessionArray = sessionGenerator(totalNumberOfBatch);
	}

	else {
		var sessionArray = ["Session"];
	}


	for(var i in sessionArray) {
		var newOption = document.createElement("option");
		newOption.value = sessionArray[i];
		newOption.innerHTML = sessionArray[i];
		session.options.add(newOption);
	}
}

function Course () {
	var department = document.getElementById("department").value;
	var semester = document.getElementById("semester").value;
	var course = document.getElementById("course");
	course.innerHTML = "";

	if (department == "CSE") {
		if (semester == "1st") {
			var courseArray = [
				"Course",
				"CSE-1101",
				"CSE-1102",
				"CSE-1103",
				"CSE-1104"
			];
		}
		else if (semester == "2nd") {
			var courseArray = [
				"Course",
				"CSE-2101",
				"CSE-2102",
				"CSE-2103",
				"CSE-2104"
			];
		}
		else {
			var courseArray = ["Course"];
		}
	}
	else if (department == "ICT") {
		if (semester == "1st") {
			var courseArray = [
				"Course",
				"ICT-1101",
				"ICT-1102",
				"ICT-1103",
				"ICT-1104"
			];
		}
		else if (semester == "2nd") {
			var courseArray = [
				"Course",
				"ICT-2101",
				"ICT-2102",
				"ICT-2103",
				"ICT-2104"
			];
		}
		else {
			var courseArray = ["Course"];
		}
	}
	else {
		var courseArray = ["Course"];
	}

	for(var i in courseArray) {
		var newOption = document.createElement("option");
		newOption.value = courseArray[i];
		newOption.innerHTML = courseArray[i];
		course.options.add(newOption);
	}
}

function CourseStd () {
	var department = document.getElementById("department").firstChild.nodeValue;
	var semester = document.getElementById("semester").value;
	var course = document.getElementById("course");
	course.innerHTML = "";

	if (department == "CSE") {
		if (semester == "1st") {
			var courseArray = [
				"Course",
				"CSE-1101",
				"CSE-1102",
				"CSE-1103",
				"CSE-1104"
			];
		}
		else if (semester == "2nd") {
			var courseArray = [
				"Course",
				"CSE-2101",
				"CSE-2102",
				"CSE-2103",
				"CSE-2104"
			];
		}
		else {
			var courseArray = ["Course"];
		}
	}
	else if (department == "ICT") {
		if (semester == "1st") {
			var courseArray = [
				"Course",
				"ICT-1101",
				"ICT-1102",
				"ICT-1103",
				"ICT-1104"
			];
		}
		else if (semester == "2nd") {
			var courseArray = [
				"Course",
				"ICT-2101",
				"ICT-2102",
				"ICT-2103",
				"ICT-2104"
			];
		}
		else {
			var courseArray = ["Course"];
		}
	}
	else {
		var courseArray = ["Course"];
	}

	for(var i in courseArray) {
		var newOption = document.createElement("option");
		newOption.value = courseArray[i];
		newOption.innerHTML = courseArray[i];
		course.options.add(newOption);
	}
}

function SearchCourseType () {
	var searchType = document.getElementById("searchType").value;
	var searchInput = document.getElementById("searchInput");
	searchInput.innerHTML = "";

	if (searchType == "department") {
		searchInput.innerHTML = '<select class="form-control" id="department" name="searchKey" required></select>';
		Department();
	}

	else if (searchType == "courseCode") {
		searchInput.innerHTML = '<input type="text" class="form-control" name="searchKey" placeholder="Enter Course Code" required>';
	}
	else {
	}
}


function SearchCourseTypeStd () {
	var searchType = document.getElementById("searchType").value;
	var searchInput = document.getElementById("searchInput");
	searchInput.innerHTML = "";

	if (searchType == "semester") {
		searchInput.innerHTML = '<select class="form-control" name="searchKey" id="semester" required></select>';
		Semester();
	}

	else if (searchType == "courseCode") {
		searchInput.innerHTML = '<input type="text" class="form-control" name="searchKey" placeholder="Enter Course Code" required>';
	}
	else {
	}
}



function sessionGenerator (totalNumberOfBatch) {
	var sessionArray = ["Session"];
	var hBatch = 17;
	for (var i=totalNumberOfBatch; i>=1; i--) {
		var s1 = 2003 + hBatch - i + "";
		var s2 = 4 + hBatch - i + "";
		if (s2.length == 1) {s2 = "0"+s2;}
		var session = s1+"-"+s2;

		sessionArray[i] = session;
	}

	return sessionArray;
}
