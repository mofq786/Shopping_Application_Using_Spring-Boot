function updateOptions()
{
	const category = document.getElementById("category").value;
            // Get the options select box
            const options = document.getElementById("option");
            // Clear existing options
            options.innerHTML = "";
            // Define options for each category
            const categoryOptions = {
                "Mobile": ["Apple", "OPPO", "ONE Plus", "Samsung","Nokia"],
                "MEN": ["Nike", "Puma", "Adidas"],
                "WOMEN": ["Nike", "Puma", "Adidas"],
                "Electronics":["Boat"]
            };
            // Get the relevant options for the selected category
            const selectedOptions = categoryOptions[category] || [];
            // Append new options
            selectedOptions.forEach(function(option) {
                const optionElement = document.createElement("option");
                optionElement.value = option;
                optionElement.textContent = option;
                options.appendChild(optionElement);
            });
        }
