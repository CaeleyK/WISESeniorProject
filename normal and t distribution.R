library(ggplot2)
library("readr")
png(file = "/Users/caeleykardell/Desktop/My Plot.png", width = 500, height = 500)
normal_distribution <- ggplot(data.frame(x=c(-3,3)),aes(x=x)) + stat_function(fun=dnorm, size=1.2, aes(colour="normal distribution"))
sample_size_string = read_lines("/Users/caeleykardell/Desktop/test")
sample_size = as.integer(sample_size_string)
#sample_size = strtoi(num, base = 10)
#sample_size <- 3
normal_dis_and_t<- normal_distribution + stat_function(fun=dt, size=1.2, args=list(df=sample_size), aes(colour="t-distribution"))
normal_dis_and_t<- normal_dis_and_t + xlab("Number of Standard Deviations") + ylab("Probability Density")
normal_dis_and_t<- normal_dis_and_t + theme_classic()
normal_dis_and_t<- normal_dis_and_t + scale_colour_manual("Distributions", values= c("lightblue2","slateblue3"))
#normal_dis_and_t
dev.off()

