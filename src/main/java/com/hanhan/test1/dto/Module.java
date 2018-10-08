package com.hanhan.test1.dto;

import java.util.HashSet;
import java.util.Set;

public class Module {
    private Integer mid;

    private String mname;

    private Set<Role> roles=new HashSet<Role>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }


    @Override
    public String toString() {
        return "Module{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", roles=" + roles +
                '}';
    }
}