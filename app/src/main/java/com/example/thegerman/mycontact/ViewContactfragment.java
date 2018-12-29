package com.example.thegerman.mycontact;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thegerman.mycontact.models.Contacts;
import com.example.thegerman.mycontact.utils.CustumListAdapter;

import java.util.ArrayList;

public class ViewContactfragment extends Fragment {
    private static final String TAG = "ViewContactfragment";
    private static final int STANDARD_APPBAR = 0;
    private static final int SEARCH_APPBAR = 1;
    private String testImageUrl = "https://app-1520876794.000webhostapp.com/img/joz.jpg";
    private CustumListAdapter custumListAdapter;
    private ListView contactList;

    private int mAppbarState;
    private AppBarLayout viewContactbar,searchBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_contact,container,false);
        viewContactbar = view.findViewById(R.id.contactToolBar);
        searchBar = view.findViewById(R.id.searchToolBar);
        contactList = view.findViewById(R.id.contactview);

        setupContactList();
        // Floatin action button
        FloatingActionButton floatingActionButton =  view.findViewById(R.id.fabAddbutton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageView imageView = view.findViewById(R.id.ivSearchIcon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleToolbarState();
            }
        });

        ImageView backArrow = view.findViewById(R.id.ivBackIcon);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleToolbarState();
            }
        });

        return view;
    }

    private void setupContactList(){
        final ArrayList<Contacts> contacts =  new ArrayList<>();
        contacts.add(new Contacts("Quince Joz-Bruer","(509) 36 72 8422","quincejozbruer@gmail.com"
        ,"Mobile","03,Village vernet",testImageUrl));
        contacts.add(new Contacts("Quince Joz-Bruer","(509) 36 72 8422","quincejozbruer@gmail.com"
                ,"Mobile","03,Village vernet",testImageUrl));
        contacts.add(new Contacts("Quince Joz-Bruer","(509) 36 72 8422","quincejozbruer@gmail.com"
                ,"Mobile","03,Village vernet",testImageUrl));
        contacts.add(new Contacts("Quince Joz-Bruer","(509) 36 72 8422","quincejozbruer@gmail.com"
                ,"Mobile","03,Village vernet",testImageUrl));
        contacts.add(new Contacts("Quince Joz-Bruer","(509) 36 72 8422","quincejozbruer@gmail.com"
                ,"Mobile","03,Village vernet",testImageUrl));
        contacts.add(new Contacts("Quince Joz-Bruer","(509) 36 72 8422","quincejozbruer@gmail.com"
                ,"Mobile","03,Village vernet",testImageUrl));
        contacts.add(new Contacts("Quince Joz-Bruer","(509) 36 72 8422","quincejozbruer@gmail.com"
                ,"Mobile","03,Village vernet",testImageUrl));
        contacts.add(new Contacts("Quince Joz-Bruer","(509) 36 72 8422","quincejozbruer@gmail.com"
                ,"Mobile","03,Village vernet",testImageUrl));
        contacts.add(new Contacts("Quince Joz-Bruer","(509) 36 72 8422","quincejozbruer@gmail.com"
                ,"Mobile","03,Village vernet",testImageUrl));
        contacts.add(new Contacts("Quince Joz-Bruer","(509) 36 72 8422","quincejozbruer@gmail.com"
                ,"Mobile","03,Village vernet",testImageUrl));

        custumListAdapter = new CustumListAdapter(getActivity(),R.layout.contact_list_item,contacts,"https://");
        contactList.setAdapter(custumListAdapter);
    }

    /**
     * Initiates the appbar state toggle
     */
    private void toggleToolbarState(){
        if (mAppbarState == STANDARD_APPBAR){
            setAppBarState(SEARCH_APPBAR);
        }else {
            setAppBarState(STANDARD_APPBAR);
        }
    }

    /**
     * Sets the appbar  state  for either  the search 'mode' or standard 'mode'
     * @param state
     */
    private void setAppBarState(int state) {
        mAppbarState = state;
        if (mAppbarState == STANDARD_APPBAR){
            searchBar.setVisibility(View.GONE);
            viewContactbar.setVisibility(View.VISIBLE);
            // Hidden the keyboard
            View view = getView();
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            try {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
            }catch (NullPointerException e){
                e.getMessage();
            }
        }
        else if (mAppbarState == SEARCH_APPBAR){
            viewContactbar.setVisibility(View.GONE);
            searchBar.setVisibility(View.VISIBLE);

            // Open the keyboard
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
           inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        setAppBarState(STANDARD_APPBAR);
    }
}
