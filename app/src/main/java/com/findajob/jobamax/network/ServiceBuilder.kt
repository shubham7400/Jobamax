import com.findajob.jobamax.network.getJobsPikrBaseUrl
import com.findajob.jobamax.network.getJoobleBaseUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(getJoobleBaseUrl()) // change this IP for testing by your actual machine IP
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

    private val jobsPikrRetrofit = Retrofit.Builder()
        .baseUrl(getJobsPikrBaseUrl()) // change this IP for testing by your actual machine IP
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildServiceJobsPikr(service: Class<T>): T {
        return jobsPikrRetrofit.create(service)
    }
}