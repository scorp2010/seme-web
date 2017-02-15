/**
 * 
 */
package com.sem.vault;

import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultClient;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

/**   
 * @Title: VaultApp.java 
 * @Package com.sem.vault 
 * @Description: 
 * @author brook.xu
 * @date 2017年1月17日 下午4:55:18 
 * @version V1.0   
 */
public class VaultApp {
	public static void main(String[] args) {
		VaultTemplate vaultTemplate = new VaultTemplate(new VaultClient(),
                new TokenAuthentication("00000000-0000-0000-0000-000000000000"));

        Secrets secrets = new Secrets();
        secrets.username = "hello";
        secrets.password = "world";

        vaultTemplate.write("secret/myapp", secrets);

        VaultResponseSupport<Secrets> response = vaultTemplate.read("secret/myapp", Secrets.class);
        System.out.println(response.getData().getUsername());

        vaultTemplate.delete("secret/myapp");
	}
}
