/**
	Aug 20, 2019
	deepakk
 */
package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author deepakk
 *
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
