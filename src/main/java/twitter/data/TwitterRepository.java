package twitter.data;

import twitter.Twitter;

public interface TwitterRepository {
    Twitter save(Twitter twitter);
    Twitter findByUsername(String username);

}
