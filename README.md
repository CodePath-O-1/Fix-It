App Design Project
===

# FIX IT!

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
An app that gathers homeowners, renters, and professionals to discuss home projects with ways to repair or fixes. Users are able to find professionals in their local area.

### App Evaluation
- **Category:** Social Networking/Services
- **Mobile:** Mobile is a fast and easy way for customers and professionals to connect with their needs.
- **Story:** Creates a platform for demands in the form of home repairs/services which is not readily available in today’s world. By having a streamlined application that can both advertise and fulfill needs, people are more inclined to spread and utilize the application.
- **Market:** The clients can be anyone who owns or rents a home (mostly adults). The professionals are people who have licenses or certifications related to home/building.
- **Habit:** This app can be used at least once per year when cleaning up their home, when maintenance is needed or for remodeling projects. It can be used as often to ask questions, give suggestions, or to showcase their home projects. 
- **Scope:** Allow users to browse Q/A on home projects and allow professionals to advertise their services.


## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* Login
* Register
    - User/Professional
* Home (User)
    - Create posts
    - menu to categories
    - Respond to posts as 'user' tag
* Home (Professional)
    * menu to categories
    * Answer posts with 'professional' tag
    * Unable to create new posts 
* Profile (user)
    * Basic information of user 
* Profile (professional)
    * Verification of identity
    * Basic information and profession
* Detail
    * image (not required)
    * question
    * report functionality 



**Optional Nice-to-have Stories**
* Tips to pop up when open app
* Administration to monitor users and professionals
* Setting
    * Choose to show private information or not 
    * change password
* rating
* upload profile image
* reply to posts
* other users can DM other users
* Search posts
* Professionals can advertise
* Users can search for repair/fix based on their location

### 2. Screen Archetypes

* Login
    * user can log in
* Register
    - user can register for an account for User/Professional (bool), (professional) location
* Home (User)
    - Create posts
    - menu to categories
    - Respond to posts as 'user' tag
* Home (Professional)
    * menu to categories
    * Answer posts with 'professional' tag
    * Unable to create new posts 
* Profile (user)
    * Basic information of user 
* Profile (professional)
    * Verification of identity
    * Basic information and profession
* Detail
    * other user or professional can reply
    * image (not required)
    * question
    * report functionality 


### 3. Navigation
**Tab Navigation (top)** (Tab to Screen)
* Categories
* logout


**Tab Navigation (bottom)** (Tab to Screen)

* Detail
* Home
* Create
* Account

**Flow Navigation** (Screen to Screen)
* Login
    - Home
* Register
    - Login
* Home
    - Detail
* Setting
    * Login
* Account 
    * Home
* LogOut
    * Login


## Wireframes

<img src="images/wireframe1.png" width=600> <br/>
<img src="images/wireframe2.png" width=600> <br/>
<img src="images/wireframe3.png" width=600> <br/>

### [BONUS] Digital Wireframes & Mockups
<img src="./images/Login.jpg" width=140><img src="./images/RegisterUser.jpg" width=140><img src="./images/Home.jpg" width=140><img src="./images/Compose.jpg" width=140> 
<img src="./images/DetailPost.jpg" width=140><img src="./images/ProfileEdit.jpg" width=140><img src="./images/ProfileUser.jpg" width=140>
<br/>

### [BONUS] Interactive Prototype
<img src="./images/figma_walkthrough1.gif" width=300>

## Schema 
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
