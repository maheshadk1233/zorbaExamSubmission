package com.example.controller;

import com.example.entity.UserInfoEntity;
import com.example.model.Inventory;
import com.example.model.UserInfoModel;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping(path = "/saveUser")
    public String saveUser(@ModelAttribute(name = "userInfoModel") UserInfoModel userInfoModel, Model model) {
        String message = "";
        if (userInfoModel != null) {
            message = userInfoService.saveUserInfo(userInfoModel);
            System.out.println("data saved!");

        }
        model.addAttribute("message", message);
        return "saveUserView";
    }

    @GetMapping(path = "/getAllUser")
    public String getAllUser(Model model) {
        List<UserInfoEntity> userInfoEntityList = userInfoService.getAllUserInfo();
        System.out.println(userInfoEntityList.get(0));
        model.addAttribute("userList", userInfoEntityList);
        return "viewUser";
    }

    @RequestMapping(value = "/addRoles", method = RequestMethod.POST)
    public String addRoles(@RequestParam("userId") String userId,
                           @RequestParam(value = "role") String role,
                           Model model) {
        System.out.println("addRole, userId " + userId);
        System.out.println(role);
        if (role != null) {
            // userInfoService.saveUserRole(userId, role);
        }
        model.addAttribute("userId", userId);

        return "success";
    }

    @RequestMapping("/getRollerId")
    public String getRollerId(@RequestParam("userId") String userId, Model model) {

        model.addAttribute("userId", userId);
        return "addRoles";

    }

    //exam section
    @RequestMapping(value = "/vendorController")
    public String vendorController(@RequestParam("name") String name,
                                   @RequestParam("password") String password,
                                   @RequestParam("role") String role,
                                   Model model) {
        UserInfoEntity user = userInfoService.vendorValidation(name, password, role);
        if (user == null) {
            return "invalidVendorInputs";
        }
        return "addInventory";
    }

    @RequestMapping(value = "/addInventory")
    public String addInventory(@ModelAttribute("inventory") Inventory inventory) {
        String message = userInfoServicegit git.saveInventory(inventory);
        return null;
    }

}
//Write a Spring Web MVC program and create necessary configuration files and
//complete end to end coding.
//        Part 1
//Create a new JSP with a form user information
//fields are as below:
//        1. Name
//2. Email
//3. Mobile
//4. Username
//5. Password
//Once form submitted then data should be saved into the database table name
//‘user_info’ with the columns as mentioned in the fields list.
//Schema of the table as
//User_info (user_id int(7) pk, name varchar(255), email varchar(50), mobile
//int(10), username
//varchar(30), password varchar(30))
//Make user we should be using hibernate to save the data.
//        Part 2
//Validation while saving data to database.
//I. Email should be containing @ if not then return to error page saying ‘Data
//provided not correct...’
//II. Mobile number should be of 10 numbers if more than that then return to error
//page saying ‘Mobile number incorrect...’
//III. Password at least 8 character, below that length of password would be
//return to error page saying ‘password incorrect should be minimum 8
//character...’
//Fetch the all data from database and display to the viewUser.jsp page
//in tabular format. Where the userId would be display and hyperlink, on
//click of a hyperlink it would be forwarding a new tsp named
//‘addRoles.jsp’
//In addRole.jsp we would be displaying the role names in a dropdown
//        (values of dropdown - “ADMIN”, “USER”, “VENDOR” ) and the add
//button option.
//On submit from addRole.jsp page would be forwarded the information
//of the role name and the user details to new controller post method
//where we will be saving data to database as
//Role (role_id int(6), role_name varchar(50))
//Need to create ManyToMany relationship with the user.
//
//        5.
//
//        1.
//
//        2.
//
//        3.
//
//        1.
//
//        2.
//
//        3.
//
//        4.
//Ex. - user id 1 can have admin role, can have user role, can have vendor role.
//When initially user info displayed in viewUser.jsp table keep one
//column named Role in the view page, as and when we will be adding
//roles should be displayed as comma separated value.
//Part 3
//Display the role information as hyperlink in the viewUser.jsp page.
//Once we click to the hyperlink we would be forward to removeRole.jsp
//page where we will be displaying the all the roles mapped to that
//particular user along with check box. We allowed to select multiple
//roles and then cell on delete button would be deleted from the
//mapping table.
//In viewUser.jsp page where we are displaying the user information
//along with roles then we would be have one more option at top left
//corner of a table ads a link to download excel file.
//Once we click on download excel, we should be allowed to download
//all the data displaying in the table.
//        Part 4
//Create a new login page for Vendor where there will be 3 fields named,
//User Name
//Password
//        Role
//* Role input field should be auto populated with ‘Vendor’ and non
//editable.
//Create a new controller named VendorController where put validation
//of the provided username and password and the role. If matches all 3
//then should forward to add inventory page (should be a new jsp page).
//Add Inventory page would be a form where vendor need to be entered
//all the inventory details like below,
//Inventory category (input data for example. : Grocery/Cosmetics/Dairy)
//Inventory Name (input data for example. : Rice/Soap/Milk)
//Inventory quantity (input data for example. : numerical value)
//Inventory price(per unit) (input data for example. : numerical price)
//Inventory Image (input data for example. : image from internet (jpg/png))
//Inventory Description (input data for example. : descriptions of the
//        product)
//Once all the fields populated put validation as below,
//        if any of the above fields is missing we are not going to save data to
//
//4.
//
//        5.
//        6.
//
//        1.
//
//        2.
//
//        3.
//DB, and send back to error page wit error message as ‘Incomplete
//        Invetory Data, please recheck!!’
//After successful validation data needs to be saved to 2 tables named
//‘inventory_category’ and ‘inventory’ table.
//‘inventory_category’ should contains field as ‘category_id’,
//        ‘category_name’ and in ‘inventory’ table should contains
//‘inventory_name’, ‘inventory_quantity’, ‘inventory_price’,
//        ‘inventory_image’, ‘inventory_desc’
//Part 5
//We need to upload an excel containing all the information of an inventory
//        systems
//Once we submitted all data should be displayed in tabular format in the jsp
//page including the image.
//In the main tabular format data would be visible in UI like
//Category item_name item_quantity item_price item_image
//        item_description
//If image is not available please make a hyperlink as ‘please upload image’. On
//click of the image the request will be forwarded to a new page with upload
//image option visible. Once image uploaded successfully display/refresh that in
//the dashboard.
//Part 6
//Modify the Role Name (User) created in the previous steps with
//‘customer’.
//Create a new login page for Customer where there will be 3 fields
//        named,
//User Name
//Password
//        Role
//* Role input field should be auto populated with ‘Customer’ and
//non editable.
//Create a new controller named CustomerController where put
//validation of the provided username and password and the role. If
//matches all 3 then should forward to add inventory page (should be a
//        new dashboard jsp page).
//In dashboard jsp page display all the inventory information that has
//been uploaded by vendor.
//a. Display a drop down where all the inventory_category should be
//
//3.
//
//        4.
//displayed.
//b. On select of a category all the inventory items should be displayed in
//below format in the js.
//inventory Name:
//inventory quantity:
//inventory price:
//inventory image
//inventory description.
//
//After adding above information add a button called ‘Add-to_Cart’
//Once click on the button we should store information in the
//‘customer_cart’ table where we should be mapping customer_id from
//‘user_info’ table mapped with inventory_item_id from ‘inventory’ table.


//MVC exam(time: 1hr 30 min)
//Please complete the below requirement in the same code base where we are
//working for User and assignment. Should checkin to the
//‘zorba_exam_submission’ folder.
//
//Create a new login page for Admin where there will be 3 fields named,
//User Name
//Password
//        Role
//* Role input field should be auto populated with ‘Admin’ and non
//editable.
//Create a new controller named AdminController where put validation of
//the provided username and password and the role. If matches all 3
//then should forward to dashboard page (should be a new jsp page
//        named adminDashboard.jsp).
//In adminDashboard.jsp page should display all the Customer and
//vendor information with details in sperate 2 table. In each table admin
//would be having option to remove a customer and a vendor.
//From adminDashboard.jsp page there should be a hyper link. On click
//of a link to a new jsp page should be rendered, where all the inventory
//details needs to be displayed.