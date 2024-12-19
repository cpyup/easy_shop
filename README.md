# Easy Shop (Backend)

## Project Summary

The easy shop project is a full-stack application simulating an e-commerce site. The original project was unfinished and contained multiple bugs. I was tasked with completing the backend methods and locating existing bugs.

This repo houses the Java backend application, and the sql script required to create the initial database. The frontend code to interact with this Java backend is located [here.](https://github.com/cpyup/easy_shop_frontend)


## User Stories

TODO:

## Setup Instructions

To run this project, we need to take a few different steps.

### Backend Setup (IntelliJ IDE)

### Frontend (Postman)

TODO

### Frontend (Webpage)

TODO

## Technologies Used

TODO:

## Additional Tools

TODO:

## Screenshots

### Console Output

![Console Output](https://github.com/cpyup/easy_shop/blob/main/screenshots/console_output.png?raw=true)

### Postman Collection Passing

![Postman Pass](https://github.com/cpyup/easy_shop/blob/main/screenshots/postman_passing.png?raw=true)

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
> While I did not manage to get EVERYTHING, I feel that I was able to address the most important bits. While I was hoping to also make some large overhauls to the page design, I did make a *few* modifications.

#### QOL Improvements

> Implemented ability to use 'Enter' key to submit some forms
>
> Modified cart item count indicator to instead display the total quantity of products

#### Visual Overhaul

> Swapped bootswatch theming to something easier on the eyes, made minor css adjustments to specific elements,
>
> Adjustments to visual styling of the header and a few other elements,

#### Shopping Cart

> Shopping cart methods adjusted, checkout now looks for and deducts from current product stock before processing.

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

## Resources

TODO:
