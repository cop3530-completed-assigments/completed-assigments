# COP3530 - Data Structures Assignments

This repository is a collection of completed assignments from the COP3530 Data Structures class at FIU. The goal of this project is to provide a centralized place where students can share their work, learn from each other's solutions, and see different approaches to solving the same problems.

## Getting Started

### 1. Install Git

If you don't have Git installed, follow these steps:

#### Windows:
1. Download Git from [git-scm.com](https://git-scm.com/download/win)
2. Run the installer and follow the on-screen instructions
3. Verify installation by opening Command Prompt and typing:
   ```bash
   git --version
   ```

#### macOS:
1. Install Homebrew if you don't have it:
   ```bash
   /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```
2. Install Git:
   ```bash
   brew install git
   ```
3. Verify installation:
   ```bash
   git --version
   ```

#### Linux (Debian/Ubuntu):
```bash
sudo apt update
sudo apt install git
```

### 2. Clone the Repository

1. Open your terminal or command prompt
2. Navigate to where you want to store the project
3. Run:
   ```bash
   git clone https://github.com/your-username/completed-assigments.git
   cd completed-assigments
   ```

## How to Contribute

### 1. Set Up Your Environment

1. **Configure Git** (if you haven't already):
   ```bash
   git config --global user.name "Your Name"
   git config --global user.email "your.email@example.com"
   ```

2. **Create a new branch** using the format `username/feature-description`:
   ```bash
   git checkout -b yourusername/add-assignments
   ```

### 2. Add Your Assignments

1. **Create a folder** with your GitHub username in the repository root
   ```bash
   mkdir yourusername
   ```

2. **Add your projects** inside your username folder using this naming convention:
   ```
   assignment_{number}_{name_of_the_assignment}
   ```
   Examples:
   - `assignment_01_algorithms`
   - `assignment_02_linked_lists`
   - `assignment_03_stacks_and_queues`

### 3. Create a Pull Request (PR)

1. **Stage your changes**:
   ```bash
   git add .
   ```

2. **Commit your changes** with a descriptive message:
   ```bash
   git commit -m "Add assignment solutions for [assignment name]"
   ```

3. **Push your branch** to GitHub:
   ```bash
   git push -u origin yourusername/add-assignments
   ```

4. **Create a Pull Request**:
   - Go to the repository on GitHub
   - Click "Compare & pull request"
   - Add a descriptive title and comment
   - Click "Create pull request"

### 4. After Your PR is Merged

1. **Update your local main branch**:
   ```bash
   git checkout main
   git pull origin main
   ```

2. **Delete your feature branch** (optional):
   ```bash
   git branch -d yourusername/add-assignments
   git push origin --delete yourusername/add-assignments
   ```

## Best Practices
- Always create a new branch for each set of changes
- Keep your branch names in the format `username/feature-description`
- Write clear commit messages
- Keep PRs focused on a single assignment or feature

Happy coding!
