package com.lowleveldesign.projects.bookmyshow;

public class AdminService {
    private static AdminService instance;
    private AdminService() {

    }

    public static AdminService getInstance() {
        if(AdminService.instance == null) {
            synchronized(AdminService.class) {
                AdminService.instance = new AdminService();
            }
        }

        return AdminService.instance;
    }


}
