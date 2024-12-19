# Easy Shop (Backend)

## Project Summary

The easy shop project is a full-stack application simulating an e-commerce site. The original project was unfinished and contained multiple bugs. I was tasked with completing the backend methods and locating existing bugs.

This repo houses the Java backend application, and the sql script required to create the initial database. The frontend code to interact with this Java backend is located [here.](https://github.com/cpyup/easy_shop_frontend)

Originally, I had planned to revamp the stores theme after completing my primary objectives (adjusting the default categories and product names/descriptions, populating with new images, etc.). After looking at the amount of data in the db, I very quickly backtracked on that.

After seeing the features present in the webpage, I decided to reorient, and work to integrate as much of the functionality present in the backend as I possibly could with the remaining time until presentation day. I am happy to say that I was able to integrate all of the features that we worked on, as well as a few other updates.


## User Stories

> As a user, I would like the ability to search for products based on the category type
>
> As an administrator, I need to be able to make modifications to the product categories (i.e. update/delete existing, add new)
>
> As a user, I would like to be able to search for products based on a price range.
>
> As an administrator, I need to be able to make updates to products so that I can accurately represent our stores inventory by making changes when necessary.
>
> As a user, I need to be able to add products to my shopping cart so that I can move to complete my transaction.
>
> As a user, I want to be able to view my user profile, so that I can verify my information is up to date.
>
> As a user, I need to be able to purchase the items in my cart, because that is how stores function.
>
> As an administrator, I need purchases to automatically update the current product inventory, so that our listings remain accurate.

## Setup Instructions

To run this project, we need to take a few different steps.

### Database Setup (MySQL)

TODO

### Backend Setup (IntelliJ IDE)

TODO

### Frontend (Postman)

TODO

### Frontend (Webpage)

TODO

## Technologies Used

TODO

## Additional Tools

[Animated Text Generator](https://www.textstudio.com/text-animation-generator)

[Text To ASCII](https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20)

[Bootswatch](https://bootswatch.com/slate/#top)

**INSPECT ELEMENT**

## Screenshots

### Console Output

![Console Output](https://github.com/cpyup/easy_shop/blob/main/screenshots/console_output.png?raw=true)

### Postman Collection Passing

![Postman Pass](https://github.com/cpyup/easy_shop/blob/main/screenshots/postman_passing.png?raw=true)

### Frontend Application Home Page

#### Logged Out

![Logged Out](https://github.com/cpyup/easy_shop/blob/main/screenshots/main.png?raw=true)

#### Logged In As User

![User](https://github.com/cpyup/easy_shop/blob/main/screenshots/main_user.png?raw=true)

#### Logged In As Administrator

![Admin](https://github.com/cpyup/easy_shop/blob/main/screenshots/main_admin.png?raw=true)

## Project Highlights

### Bonus Implementations

#### Shopping Cart

> Implemented user shopping cart, users are able to add/view items in their carts.
>
> Added 'checkout' option for the shopping cart which converts the current cart into a new order in the database.
>
> Implemented empty cart functionality, removing the items from the cart without creating an order.

#### User Profiles

> Users are now able to view and edit their user profile information.

### My Additions

> After completing the main project and its optional tasks, my next goal became implementing all of the functionality present in the backend somewhere in the front.
>
> While I did not manage to get *everything*, I feel that I was able to address the most important bits. While I was hoping to also make some large overhauls to the page design, I did make a *few* modifications.

#### QOL Improvements

> Implemented ability to use 'Enter' key to submit some forms
>
> Modified cart item count indicator to instead display the total quantity of products

#### Visual Overhaul

> Swapped bootswatch theming to something easier on the eyes, made minor css adjustments to specific elements.
>
> Adjustments to visual styling of the header and a few other elements.
>
> Updated logo, favicon, and page title.
>
> Adjusted cart icon display elements.

#### Register User Form

> Implemented nav option when viewing the page and not signed out that opens a basic user registration form, then redirects to login after valid submission.

#### Shopping Cart

> (Backend) shopping cart methods adjusted, checkout now looks for and deducts from current product stock before processing.
>
> Implemented cart checkout functionality.
>
> Added new display for viewing an empty shopping cart.

#### Admin Options

> The website Administrator has access to an additional dropdown menu in the navbar. From here, the administrator is able to add new products, and add/remove/delete categories (provided they are not referenced elsewhere, this feature is primarily for deleting newly created categories not in use)
>
> Additionally, when the website admin is viewing the products page, every product now has an additional button. This will take the administrator to a new page that allows them to either delete or edit that product.

## Future Work

### Planned

#### General Error Handling (Frontend)

> There are a few features that I had time to implement only the core functionality. There are a lot of places where you can perform actions that will inevitably fail once they reach the backend (error handling there is fairly solid). If I had some more time with it, I would go back through and clean up all of those occurrences so as to provide a cleaner user experience. 

#### Order Handling (Feature Update)

> Before a user can checkout their cart, there should be profile information present. Implement checks and direct a user to complete their information before submitting the order.

#### Cart Handling (Feature Update)

> Add-to-cart options on products should disable when current inventory is too low/empty.
>
> Displaying of error message if checkout fails due to low inventory (currently just fails)
>
> Indication of current store inventory from cart items


### Potential

#### Search Bar
> Just a product search bar. Would have placed it somewhere in the navbar. Would have had to implement functionality on both the front and back end for this.

#### 'Featured' Items

> Find some way to implement utilization of the 'featured' value on products
>
>Ideas for this centered around either having the main product display adjust to show featured items towards the top (along with some sort of visual indicator that it is featured), or creating a new page layout, which forced navigation past the featured products before viewing non-featured.
>
>While I did manage to do some mental mock-ups of potential layouts (I preferred the hard way, of course), I pretty quickly cut the feature for time.

#### Discount Codes

> As my main goal was to implement all present functionalities, I really wanted to make use of the discount parameters present in the products. 
>
> This would have involved establishing a new table in the database which could store different discount codes and product ids that they apply to (some would not require specific products, some would instead require a minimum cart total, etc.)
>
> Obviously, that would have ended up being way more work than my single week could handle, so that was cut.

#### Mock Payment Submission

> This would have been implemented primarily on the backend, and require a user to submit a valid card number when checking out.
>
> The feature would have just validated the checksum with an implementation of the [Luhn Algorithm,](https://en.wikipedia.org/wiki/Luhn_algorithm) not actually process any charges. 
>
>While this would have been a lot of fun, sadly, it as well was cut for time.

## Resources

[W3Schools](https://www.w3schools.com/)

[Google](https://www.google.com/)
