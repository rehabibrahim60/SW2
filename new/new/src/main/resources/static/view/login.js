function validateForm() {
	const username = document.getElementById("username").value.trim();
	const password = document.getElementById("password").value.trim();
	const id = document.getElementById("id").value.trim();

	if (username === "" || password === "" || id === "") {
		alert("Please fill in all fields.");
		return false;
	}

	return true;
}