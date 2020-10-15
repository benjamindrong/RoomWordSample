package com.ghmobile.roomwordsample;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ghmobile.roomwordsample.model.Word;

import java.util.List;

/**
 * Warning: Don't keep a reference to a context that has a shorter lifecycle than your ViewModel! Examples are:
 *
 * Activity
 * Fragment
 * View
 * Keeping a reference can cause a memory leak, e.g. the ViewModel has a reference to a destroyed
 * Activity! All these objects can be destroyed by the operative system and recreated when there's a
 * configuration change, and this can happen many times during the lifecycle of a ViewModel.
 *
 * If you need the application context (which has a lifecycle that lives as long as the application
 * does), use AndroidViewModel, as shown in this codelab.
 *
 * Important: ViewModels don't survive the app's process being killed in the background when the OS
 * needs more resources. For UI data that needs to survive process death due to running out of
 * resources, you can use the Saved State module
 * https://developer.android.com/topic/libraries/architecture/viewmodel-savedstate for ViewModels.
 * Learn more here:
 * https://medium.com/google-developers/viewmodels-persistence-onsaveinstancestate-restoring-ui-state-and-loaders-fc7cc4a6c090.
 */
public class WordViewModel extends AndroidViewModel {

    private final WordRepository mRepository;

    private final LiveData<List<Word>> mAllWords;

    public WordViewModel (Application application) {

        super(application);

        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();

    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void deleteAll() {
        mRepository.deleteAll();
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }

}
