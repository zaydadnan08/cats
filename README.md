# Verkada Take home app 


## Jetpack Compose: 
Since both UI for home and favorites page are very similar, created a single generic compose element PictureView for both UI's. 
The screen type is sent into the element to differ between showing all pictures or just favorited pictures.

## mvvm: 
Used a simplified version of MVVM with a singluar viewmodel, MainComposeViewModel, for the MainComposeActivity class. 
Used this to store/observe UI information for home and favorites page.
Utilised mutableStateListOf for the list of pictures/favorited pictures, pictures and favorites respectively. 
Utilised mutableStateOf for the simple info such as page number and if the page was loading. 

## Next Steps: 
Note: Didn't implement local storage of favorited pictures, since did not see this shown in demo vid/description. 

Note: for pagination, I did reference code from CodingWithMitch: https://www.youtube.com/watch?v=Z4FnYeYR_fo&t=971s&ab_channel=CodingWithMitch

