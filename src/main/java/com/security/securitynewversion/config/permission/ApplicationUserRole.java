package com.security.securitynewversion.config.permission;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.security.securitynewversion.config.permission.ApplicationUserPermission.*;

public enum ApplicationUserRole {

    CUSTOMER(Sets.newHashSet(ORDER_WRITE,PRODUCT_READ,CUSTOMER_READ,CUSTOMER_WRITE)),
    ADMIN(Sets.newHashSet(ORDER_READ,ORDER_WRITE,PRODUCT_READ,PRODUCT_WRITE,CUSTOMER_WRITE,CUSTOMER_READ)),
    MANAGER(Sets.newHashSet(ORDER_READ,PRODUCT_READ,CUSTOMER_READ));


    private final Set<ApplicationUserPermission> permission;


    ApplicationUserRole(Set<ApplicationUserPermission> permission) {
        this.permission = permission;
    }

    public Set<ApplicationUserPermission> getPermission() {
        return permission;
    }
}
