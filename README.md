# Implementation:

### Q) What libraries did you add to the app? What are they used for?

I have used my common suite of libraries for rapid development.
- Java JSR-310 backport optimized for Android to work with time
- RxJava to simplify asynchronous operations and threading in general
- Retrofit for fast API wiring
- GSON and gson class generators for JSON
- Glide for image loading
- RecyclerView, CosntraintLayout, CardView as widgets to build some parts of UI 

---


# General:

### Q) How long did you spend on the test?

~7 hours

### Q) If you had more time, what further improvements or new features would you add?

My first thing would be to understand better business needs, user needs, user auditory, internet speed, a range of devices. From there I would rank tasks by value/effort and iterate.

Some things which are on my list are:

* Sorting by satisfaction
* Ask designers for Progress Bar
* Communicate with designers about some paddings and margins to follow material guidelines
* Architecture, including the use of UI patterns such as(MVP/MVVM)
* Tests
* Handling config changes i.e. caching intermediate results of requests
* Cache partially intermediate poll results for better performance
* Consider JSON streaming
* Consider using a binary format such as protobuf etc.
* Measure performance/battery of polling vs sockets. What about http/2?
* API key protection
* Error handling(HTTP codes and other possible errors)
* Nullability of API is not clear
* Improve performance of UI by using custom views. Direct work with Layout instead of TextView, ViewGroup instead of ConstraintLayout, Drawable instead of ImageView.
* Proguard rules

### Q) Which parts are you most proud of? And why?

The task is very trivial for me, so there is nothing much to be proud of.

### Q) Which parts did you spend the most time with? What did you find most difficult?

Figuring out the structure of models took the most amount of time. Nothing really difficult here.

### Q) How did you find the test overall? If you have any suggestions on how we can improve the test or our API, we'd love to hear them.

I have mixed feelings, I usually prefer to talk directly to candidates if the resume looks interesting to me and see how they tackle the problem real-time. This allows us quickly figure out is it worth to move on, only if we have a diverse opinion about a candidate we are giving extra task home. Another idea here is to save the time of both parties. 

But I understand that each company has its own flow and for different teams there are might be different approaches in hiring. I hope that my assignment will give some value and help somehow Skyscanner application.