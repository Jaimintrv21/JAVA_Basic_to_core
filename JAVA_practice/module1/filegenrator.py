import os

def create_java_files(start_name, end_suffix):
    try:
        start_version = float(start_name.split("_")[1])
        end_version = float(end_suffix.split("_")[1])
    except (IndexError, ValueError):
        print("Invalid start or end name format. Use the format 'module1_1.0' and 'module1_1.12'.")
        return

    if end_version <= start_version:
        print("End version must be greater than start version.")
        return

    # Ensure the directory exists
    os.makedirs("output", exist_ok=True)

    version = start_version
    while version <= end_version:
        file_name = f"output/{start_name.split('_')[0]}_{version}.java"
        class_name = f"{start_name.split('_')[0]}_{str(version).replace('.', '_')}"

        # Create the content of the .java file
        content = f"""// Auto-generated file
public class {class_name} {{
    public static void main(String[] args) {{
        System.out.println(\"Hello from {class_name}!\");
    }}
}}
"""

        # Write the content to the file
        with open(file_name, "w") as file:
            file.write(content)

        version = round(version + 0.01, 2)

    print(f"Java files created in the 'output' directory from {start_name} to {end_suffix}.")

# Example usage
start_name = "module1_1.0"
end_suffix = "module1_1.12"
create_java_files(start_name, end_suffix)
