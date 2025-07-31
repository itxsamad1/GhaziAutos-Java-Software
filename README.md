# 🚗 GhaziAutos - Auto Parts Management System

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

**A comprehensive inventory management solution for automotive parts warehouses and retail operations**

[Features](#-features) • [Installation](#-installation) • [Usage](#-usage) • [Screenshots](#-screenshots) • [Contributing](#-contributing)

</div>

---

## 📋 Overview

GhaziAutos is a robust Java-based inventory management system specifically designed for automotive parts warehouses and selling points. Built with Java Swing for an intuitive desktop experience, this software streamlines inventory tracking, sales management, and customer relations for auto parts businesses.

### 🎯 Purpose
This software was custom-developed for a client's auto-vehicle parts warehouse to digitize and optimize their inventory management processes, replacing manual tracking systems with an efficient, user-friendly digital solution.

## ✨ Features

### 🏪 **Inventory Management**
- **Real-time Stock Tracking** - Monitor parts availability and quantities
- **Low Stock Alerts** - Automated notifications for reorder points
- **Batch Management** - Track parts by batch numbers and expiry dates
- **Category Organization** - Organize parts by vehicle type, brand, and category

### 💰 **Sales & Billing**
- **Point of Sale (POS)** - Quick and efficient checkout process
- **Invoice Generation** - Professional invoice creation and printing
- **Payment Tracking** - Multiple payment method support
- **Sales Analytics** - Daily, weekly, and monthly sales reports

### 👥 **Customer Management**
- **Customer Database** - Comprehensive customer information storage
- **Purchase History** - Track customer buying patterns
- **Loyalty Programs** - Implement customer reward systems
- **Credit Management** - Handle customer credit accounts

### 📊 **Reporting & Analytics**
- **Sales Reports** - Detailed sales performance analysis
- **Inventory Reports** - Stock levels and movement tracking
- **Profit Analysis** - Revenue and profit margin calculations
- **Export Capabilities** - Export reports to PDF and Excel formats

### 🔐 **Security & User Management**
- **Multi-user Support** - Role-based access control
- **Secure Login** - Password-protected user accounts
- **Activity Logging** - Track user activities and changes
- **Data Backup** - Automated backup and restore functionality

## 🛠️ Technology Stack

| Component | Technology |
|-----------|------------|
| **Backend** | Java (JDK 8+) |
| **GUI Framework** | Java Swing |
| **Database** | MySQL (using XAMPP) |
| **Build Tool** | Maven/Gradle |
| **Architecture** | MVC (Model-View-Controller) |
| **Reporting** | JasperReports |

## 📦 Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- MySQL Server 5.7 or higher
- Maven (for building from source)

### Quick Start

1. **Clone the Repository**
   ```bash
   git clone https://github.com/itxsamad1/GhaziAutos-Java-Software.git
   cd GhaziAutos-Java-Software
   ```

2. **Database Setup**
   ```sql
   -- Create database
   CREATE DATABASE ghazi_autos;
   
   -- Import the database schema
   mysql -u root -p ghazi_autos < database/schema.sql
   ```

3. **Configure Database Connection**
   ```properties
   # Update config/database.properties
   db.host=localhost
   db.port=3306
   db.name=ghazi_autos
   db.username=your_username
   db.password=your_password
   ```

4. **Build and Run**
   ```bash
   # Using Maven
   mvn clean compile
   mvn exec:java -Dexec.mainClass="com.ghaziautos.Main"
   
   # Or run the JAR file
   java -jar target/GhaziAutos.jar
   ```

## 🚀 Usage

### Initial Setup
1. Launch the application
2. Use default admin credentials: `admin/admin123`
3. Configure your business settings
4. Import your existing inventory data (if any)
5. Create user accounts for your staff

### Daily Operations

#### **Adding New Parts**
- Navigate to Inventory → Add New Part
- Fill in part details (name, category, price, quantity)
- Set reorder levels and supplier information

#### **Processing Sales**
- Use the POS interface for quick sales
- Scan barcodes or search by part name
- Generate and print invoices
- Process payments and update inventory

#### **Managing Customers**
- Add new customers with contact details
- View purchase history and outstanding balances
- Apply discounts and loyalty rewards

## 📸 Screenshots

<div align="center">

### 🏠 Dashboard
![Dashboard](docs/images/dashboard.png)
*Main dashboard showing key metrics and quick actions*

### 📦 Inventory Management
![Inventory](docs/images/inventory.png)
*Comprehensive inventory management interface*

### 💳 Point of Sale
![POS](docs/images/pos.png)
*User-friendly POS system for quick sales*

### 📊 Reports
![Reports](docs/images/reports.png)
*Detailed analytics and reporting capabilities*

</div>

## 🏗️ Architecture

```
src/
├── main/
│   ├── java/
│   │   ├── com/ghaziautos/
│   │   │   ├── controller/     # Business logic controllers
│   │   │   ├── model/          # Data models and entities
│   │   │   ├── view/           # Swing GUI components
│   │   │   ├── dao/            # Data Access Objects
│   │   │   ├── utils/          # Utility classes
│   │   │   └── Main.java       # Application entry point
│   │   └── resources/
│   │       ├── config/         # Configuration files
│   │       ├── images/         # UI icons and images
│   │       └── reports/        # Report templates
└── database/
    ├── schema.sql              # Database schema
    └── sample_data.sql         # Sample data for testing
```

## 🤝 Contributing

Contributions are welcome! Here's how you can help improve GhaziAutos:

1. **Fork the Repository**
2. **Create a Feature Branch**
   ```bash
   git checkout -b feature/new-feature
   ```
3. **Make Your Changes**
4. **Commit Your Changes**
   ```bash
   git commit -m "Add: New feature description"
   ```
5. **Push to Your Branch**
   ```bash
   git push origin feature/new-feature
   ```
6. **Open a Pull Request**

### Development Guidelines
- Follow Java coding conventions
- Write meaningful commit messages
- Add comments for complex logic
- Test your changes thoroughly
- Update documentation as needed

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Developer

**Abdul Samad**
- 🌐 GitHub: [@itxsamad1](https://github.com/itxsamad1)
- 💼 LinkedIn: [Connect with me](https://linkedin.com/in/itxsamad1)
- 📧 Email: contact@itxsamad.dev

## 🆘 Support

If you encounter any issues or have questions:

1. **Check the Issues** - Look for existing solutions
2. **Create an Issue** - Report bugs or request features
3. **Discussion** - Join community discussions
4. **Documentation** - Check the wiki for detailed guides

## 🙏 Acknowledgments

- Special thanks to the client for trusting me with this project
- Java Swing community for excellent documentation
- MySQL team for the robust database solution
- All contributors who helped improve this software

## 📈 Project Status

- ✅ **Version 1.0** - Core functionality complete
- 🔄 **Version 1.1** - Enhanced reporting features (In Progress)
- 📋 **Version 2.0** - Web-based interface (Planned)

---

<div align="center">

**⭐ Star this repository if you find it helpful!**

Made with ❤️ by [Abdul Samad](https://github.com/itxsamad1)

</div>
