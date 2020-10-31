package mes.cheveux.salon.data;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mes.cheveux.salon.common.data.BaseRepository;
import mes.cheveux.salon.common.data.NearbySalonsResponse;
import mes.cheveux.salon.common.data.SalonSearchModel;
import mes.cheveux.salon.ui.home.ModuleResponse;
import mes.cheveux.salon.ui.salon.SalonDataSourceFactory;
import mes.cheveux.salon.ui.salon.SalonModel;
import mes.cheveux.salon.ui.salon.SalonReviewsModel;
import mes.cheveux.salon.ui.salon.SalonServiceModel;

public class SalonRepository extends BaseRepository {
    private  static SalonRepository salonRepository;


    public  static SalonRepository getInstance(){
        if (salonRepository == null) {
            salonRepository = new SalonRepository();
        }

        return salonRepository;
    }



    @SuppressLint("CheckResult")
    public MutableLiveData<ModuleResponse> getHomeModules(){
        MutableLiveData<ModuleResponse> response = new MutableLiveData<>();
        apiService.getHomeModules()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response ::setValue,throwable -> response.setValue(null));

        return response;
    }


    @SuppressLint("CheckResult")
    public MutableLiveData<List<SalonServiceModel>> getSalonServices(int salonId){
        MutableLiveData<List<SalonServiceModel>> response = new MutableLiveData<>();
        apiService.salonServices(salonId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response ::setValue,throwable -> response.setValue(null));

        return response;
    }


    @SuppressLint("CheckResult")
    public MutableLiveData<List<SalonReviewsModel>> getSalonReviews(int salonId){
        MutableLiveData<List<SalonReviewsModel>> response = new MutableLiveData<>();
        apiService.salonReviews(salonId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response ::setValue,throwable -> response.setValue(null));

        return response;
    }

//    @SuppressLint("CheckResult")
//    public MutableLiveData<PageKeyedDataSource<Integer, SalonModel>> getNearbySalons(SalonSearchModel salonSearchModel){
//        SalonDataSourceFactory dataSourceFactory = new SalonDataSourceFactory(salonSearchModel);
//
//        return dataSourceFactory.getSalonDataSourceLiveData();
//    }
//

}
