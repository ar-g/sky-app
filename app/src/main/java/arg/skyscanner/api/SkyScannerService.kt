package arg.skyscanner.api

import arg.skyscanner.api.model.Response
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.Result
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface SkyScannerService {
    @FormUrlEncoded
    @POST("pricing/v1.0")
    fun createSession(
        @Field("country") country: String,
        @Field("currency") currency: String,
        @Field("locale") locale: String,
        @Field("locationSchema") locationSchema: String,
        @Field("apikey") apikey: String,
        @Field("grouppricing") grouppricing: String,
        @Field("originplace") originplace: String,
        @Field("destinationplace") destinationplace: String,
        @Field("outbounddate") outbounddate: String,
        @Field("inbounddate") inbounddate: String,
        @Field("adults") adults: String,
        @Field("children") children: String,
        @Field("infants") infants: String,
        @Field("cabinclass") cabinclass: String
    ): Observable<Result<Void>>

    @GET
    fun pollJourneys(
        @Url url: String,
        @Query("apiKey") apikey: String
    ): Observable<Response>


    companion object {
        val API_KEY = "ss630745725358065467897349852985"

        val instance: SkyScannerService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://partners.api.skyscanner.net/apiservices/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(SkyScannerService::class.java)
        }
    }
}