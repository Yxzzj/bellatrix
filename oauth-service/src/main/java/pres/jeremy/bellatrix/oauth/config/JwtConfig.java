package pres.jeremy.bellatrix.oauth.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.binary.Base64;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private String secret;
    private long expire;
    private String header;

    private SecretKey generalKey() {
        // 使用base64解码
        byte[] encodedKey = Base64.decodeBase64(secret);
        // 根据给定的字节数组使用AES加密算法构造一个密钥
        SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return secretKey;
    }

    public String createJWT(Map claims,String subject) {
        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        //将long型的时间毫秒转为日期时间
        Date now = new Date(nowMillis);

        //生成签名的时候使用的秘钥secret
//        SecretKey key = generalKey();

        //下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() //这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(claims) //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setIssuedAt(now) //iat: jwt的签发时间
                .setSubject(subject)//一个json格式的字符串作为用户的唯一标志。
                .signWith(signatureAlgorithm, secret);//设置签名使用的签名算法和签名使用的秘钥

        long expMillis = nowMillis + expire * 1000;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp); //设置过期时间戳

        return builder.compact();
    }

    public Claims getTokenClaim(String jwt) throws Exception{
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt).getBody();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean isTokenExpired (Date expirationTime) {
        return expirationTime.before(new Date());
    }
}
