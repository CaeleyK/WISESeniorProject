if(!require(readr)){install.packages('readr')}
if(!require(ggplot2)){install.packages('ggplot2')}

library(ggplot2)
library(readr)

# code should work as long as standard deviation is positive; mean can be positive or negative

mean1 <- -10
sd1 <- 8

mean2 <- 0
sd2 <- 15

# defining upper and lower boundaries

upper_x_possible_1 <- mean1+5*sd1
upper_x_possible_2 <- mean2+5*sd2

if(upper_x_possible_1 > upper_x_possible_2){
  upper_x <- upper_x_possible_1
} else {
  upper_x <- upper_x_possible_2
}

lower_x_possible_1 <- mean1-5*sd1
lower_x_possible_2 <- mean2-5*sd2 

if(lower_x_possible_1 < lower_x_possible_2) {
  lower_x <- lower_x_possible_1
} else {
  lower_x <- lower_x_possible_2
}

# creating the distributions

dis_1 <- ggplot(data.frame(x=c(lower_x,upper_x)),aes(x=x))
dis_2 <- dis_1 + stat_function(fun=dnorm, size=1.2, args=list(mean=mean1, sd=sd1), aes(col="Distribution 1"))
dis_3 <- dis_2 + stat_function(fun=dnorm, size=1.2, args=list(mean=mean2, sd=sd2), aes(col="Distribution 2"))
dis_4 <- dis_3 + theme_classic()
dis_5 <- dis_4 + scale_colour_manual("Distributions", values= c("lightblue2","slateblue3"))

# shading the regions and fixing labels 

ShadeRegion1 <- function(x) {
  y <- dnorm(x, mean=mean1, sd=sd1)
  return(y)
}

ShadeRegion2 <- function(x) {
  y <- dnorm(x, mean=mean2, sd=sd2)
  return(y)
}

dis_6 <- dis_5 + stat_function(fun=ShadeRegion1, geom= "area", fill="lightblue2", alpha=0.1)
dis_7 <- dis_6 + stat_function(fun=ShadeRegion2, geom= "area", fill="slateblue3", alpha=0.1)
dis_8 <- dis_7 + xlab("") + ylab("Probability Density")
dis_8